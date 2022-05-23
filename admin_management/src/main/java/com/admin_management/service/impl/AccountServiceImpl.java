package com.admin_management.service.impl;

import com.admin_management.caller.DriverCaller;
import com.admin_management.caller.GasStationCaller;
import com.admin_management.caller.PermissionCaller;
import com.admin_management.caller.StationNameResponse;
import com.admin_management.mapper.impl.AccountMapper;
import com.admin_management.model.bo.FindAccountInfo;
import com.admin_management.model.entity.Account;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.entity.Profile;
import com.admin_management.model.request.*;
import com.admin_management.model.response.*;
import com.admin_management.repository.AccountRepository;
import com.admin_management.repository.ProfileRepository;
import com.admin_management.service.AccountInternalService;
import com.admin_management.service.AccountService;
import com.admin_management.service.ProfileInternalService;
import com.admin_management.util.Global;
import com.admin_management.validator.AccountValidator;
import com.common.exception.BusinessException;
import com.common.model.bo.AccountStatus;
import com.common.service.OtpService;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.SessionCookieOptions;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ProfileRepository profileRepository;
    private final AccountMapper mapper;
    private final OtpService otpService;
    private final AccountInternalService service;
    private final PasswordEncoder passwordEncoder;
    private final ProfileInternalService profileInternalService;
    private final PermissionCaller permissionCaller;
    private final DriverCaller driverCaller;
    private final AccountValidator validator;
    private final EmployeeInternalServiceImpl employeeInternalService;
    private final GasStationCaller gasStationCaller;

    @Value("${app.base.url.management.password}")
    private String password;

    /**
     * Find all
     * Find Account by Search text if present
     *
     * @param searchText searchText
     * @param page       page
     * @param size       size
     * @return Page
     */
    @Override
    public Page<? extends AccountInfo> findAll(String searchText, Integer page,
                                               Integer size, String field, Sort.Direction direction) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, field));

        FindAccountInfo findAccountsInfo = findAccountsBySearchText(searchText, pageable);

        Page<Account> accountPage = findAccountsInfo.getAccounts();

        if (accountPage.isEmpty())
            return new PageImpl<>(new ArrayList<>());

        if (findAccountsInfo.hasProfiles()) {
            List<AccountInfo> accountInfos = accountPage.stream().map(mapper::mapAccountInfo).collect(Collectors.toList());
            return new PageImpl<>(accountInfos, accountPage.getPageable(), accountPage.getTotalElements());
        }

        List<Employees> employees = employeeInternalService.findByAccountIdIn(accountPage.stream().map(Account::getId).collect(Collectors.toList()));

        Map<String, Employees> employeesMap = employees.stream().collect(Collectors.toMap(Employees::getAccountId, Function.identity()));

        Map<Integer, Profile> profileMap = findAccountsInfo.toMapIdNProfile();

        List<AccountResponse> accountResponses = accountPage.stream()
                .map(it -> mapper.mapAccountResponse(it, profileMap.get(it.getProfileId()), employeesMap.get(it.getId())))
                .collect(Collectors.toList());

        return new PageImpl<>(accountResponses, accountPage.getPageable(), accountPage.getTotalElements());
    }


    /**
     * Get driver by token (jwt)
     *
     * @param accountId accountId
     * @return AccountInfo
     */
    @Override
    public AccountInfo getAccountById(String accountId) {

        Account account = validator.validate(accountId);

        Profile profile = profileInternalService.findById(account.getProfileId());

        Employees employee = employeeInternalService.findByIdAccount(account.getId());

        if (employee == null) return mapper.mapDetail(account, profile);

        List<StationNameResponse> stationNames = gasStationCaller.getStationName(employee.getId()).join().getData();

        return mapper.mapDetail(account, profile, employee.getPositions().getName(), stationNames);
    }

    /**
     * get account by id
     *
     * @param id id
     * @return AccountInfo
     */
    @Override
    public AccountInfo getAccount(String id) {

        Account account = validator.validate(id);

        return mapper.mapAccountInfo(account);
    }

    @Override
    public Boolean toggleOtp(String accountId, OtpRequest otpRequest) {
        Account account = validator.validate(accountId);

        if (checkOtp(otpRequest)) {
            account.setAuthenticationOtp(otpRequest.isAuthentication());
            repository.update(account);
            return true;
        }

        throw new BusinessException(ErrorCode.AUTHENTICATION_FAILED, ErrorCode.AUTHENTICATION_FAILED.getMessage());

    }

    @Override
    public Boolean authenticationOtp(OtpRequest otpRequest) {
        if (checkOtp(otpRequest)) return true;
        throw new BusinessException(ErrorCode.AUTHENTICATION_FAILED, ErrorCode.AUTHENTICATION_FAILED.getMessage());

    }

    /**
     * get detail account
     *
     * @param accountId accountId
     * @return AccountDetail
     */
    @Override
    public AccountDetail getInfoAccount(String accountId) {

        Account account = validator.validateAccount(accountId);

        Profile profile = profileInternalService.findById(account.getProfileId());

        Employees employees = employeeInternalService.findByIdAccount(accountId);

        RoleResponseDetail roleResponseDetail = permissionCaller.getRoleByAccountId(accountId).join().getData();

        return mapper.map(account, profile, roleResponseDetail, employees);
    }

    /**
     * change password in login first
     *
     * @param request request
     * @return LoginSuccessResponse
     */
    @Override
    public LoginSuccessResponse changePasswordInLoginFirstTime(ChangePasswordLoginFirstTimes request) {

        Account account = service.findByIdAndStatus(request.getId(), AccountStatus.FIRST, ErrorMessage.ACCOUNT_NOT_VALID);

        account.setHashPassword(passwordEncoder.encode(request.getPassword()));

        account.setStatus(AccountStatus.ACTIVE);

        account = repository.update(account);

        return mapper.map(account);
    }

    /**
     * register admin
     *
     * @param request request
     * @return AdminRegisterResponse
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AdminRegisterResponse adminRegister(EmployeeRegisterRequest request) {

        validator.validateRequest(request);

        boolean isRoleIds = permissionCaller.validateGroup(request.getRoleIds());
        if (!isRoleIds)
            throw new BusinessException(ErrorCode.GROUP_PERMISSION_INVALID,
                    String.format(ErrorMessage.GROUP_PERMISSION_INVALID, request.getRoleIds().toString()));

        Employees employees = employeeInternalService.findByEmployeeById(request.getEmployeeId());

        Profile profile = profileRepository.insert(mapper.mapProfile(employees));

        Account account = repository.insert(mapper.map(request, employees, profile));

        employees.setAccountId(account.getId());

        boolean isSaveRoles = permissionCaller.saveRolesAccount(request.getRoleIds(), account.getId());

        if (!isSaveRoles)
            throw new BusinessException(ErrorCode.GROUP_PERMISSION_INVALID,
                    String.format(ErrorMessage.GROUP_PERMISSION_INVALID, request.getRoleIds().toString()));

        return mapper.mapNewAccount(account, profile);
    }

    /**
     * update account
     *
     * @param id                   id
     * @param accountUpdateRequest accountUpdateRequest
     * @return AccountUpdateResponse
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AccountUpdateResponse update(String id, AccountUpdateRequest accountUpdateRequest) {

        Account account = validator.validateAccount(id);

        boolean isRoleIds = permissionCaller.validateGroup(accountUpdateRequest.getRoleIds());
        if (!isRoleIds)
            throw new BusinessException(ErrorCode.GROUP_PERMISSION_INVALID,
                    String.format(ErrorMessage.GROUP_PERMISSION_INVALID, accountUpdateRequest.getRoleIds().toString()));

        account = repository.update(mapper.mapUpdateAccount(account, accountUpdateRequest));

        boolean isUpdateRoles = permissionCaller.updateRolesAccount(accountUpdateRequest.getRoleIds(), account.getId());

        if (!isUpdateRoles)
            throw new BusinessException(ErrorCode.GROUP_PERMISSION_INVALID,
                    String.format(ErrorMessage.GROUP_PERMISSION_INVALID, accountUpdateRequest.getRoleIds().toString()));

        return mapper.mapUpdateResponse(account);
    }

    @Override
    public Boolean changePassword(String accountId, ChangePasswordRequest request) {

        Account account = validator.validateAccount(accountId);

        validator.validateChangePassword(account, request);

        account.setHashPassword(passwordEncoder.encode(request.getPasswordNew()));

        repository.update(account);

        return true;
    }

    @Override
    public Boolean resetPassword(String accountId) {

        Account account = validator.validateAccount(accountId);

        account.setHashPassword(passwordEncoder.encode(password));

        repository.update(account);

        otpService.revokeLoginSession(accountId);

        return true;
    }


    /**
     * delete account
     *
     * @param accountId accountId
     * @return Boolean
     */
    @Override
    public Boolean delete(String accountId) {
        Account account = validator.validateAccount(accountId);

        repository.deleteAccount(account.getId());

        otpService.revokeLoginSession(account.getId());

        updateEmployee(account);

        return true;
    }


    /**
     * Login for driver
     *
     * @param loginRequest loginRequest
     * @return LoginSuccessResponse
     */
    @Override
    public LoginSuccessResponse login(LoginRequest loginRequest) {

        Account account = repository.findByUsernameAndStatusIn(loginRequest.getUsername(), Global.lstStatusLogin)
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.ACCOUNT_NOT_FOUND,
                                String.format(ErrorMessage.ACCOUNT_NOT_FOUND_OR_ACTIVE, loginRequest.getUsername())));

        return mapper.map(account);
    }

    /**
     * Create a Driver
     *
     * @param request request
     * @return LoginSuccessResponse
     */
    @Override
    public LoginSuccessResponse register(RegisterDriverRequest request) {

        String phone = otpService.getByOtp(request.getOtp());

        Account account = repository.insert(mapper.map(request.getPassword(), phone));

        // TODO: get profile
//        Profile profile = profileRepository.findById(account.getProfileId()).orElse(null);

        // TODO: Get Role in Role service
        String role = "";

//        return mapper.map(account, profile, role);
        return null;
    }

    /**
     * Delete account Driver
     *
     * @param id id
     * @return Boolean
     */
    @Override
    public Boolean deleteDriver(String id) {
        if (!driverCaller.checkDriverExist(id).join().getData())
            throw new BusinessException(ErrorCode.ACCOUNT_NOT_FOUND_OR_DELETE,
                    String.format(ErrorMessage.ACCOUNT_NOT_FOUND_OR_DELETE, id));

        return driverCaller.deleteDriver(id).join().getData();
    }

    /**
     * Find Account if search text is null
     *
     * @param pageable pageable
     * @return FindAccountInfo
     */
    private FindAccountInfo findAccountsBySearchText(String searchText, Pageable pageable) {

        if (StringUtils.isEmpty(searchText))
            return findProfiles(repository.findByStatusNot(AccountStatus.DELETE.name(), pageable));

        searchText = "%" + searchText.toLowerCase().trim() + "%";

        List<Profile> profiles = profileInternalService.findByNameLike(searchText);

        if (CollectionUtils.isEmpty(profiles))
            return findProfiles(repository.findByUsernameAndStatusNativeQuery(searchText, AccountStatus.DELETE.name(), pageable));

        List<Integer> profileIds = profiles.stream().map(Profile::getId).collect(Collectors.toList());

        Page<Account> accounts = repository.findByUsernameOrProfileIdInAndStatusNativeQuery(searchText, profileIds, AccountStatus.DELETE.name(), pageable);
        return findProfiles(accounts);
    }

    /**
     * Find Profile list by account list
     *
     * @param accountPage accountPage
     * @return FindAccountInfo
     */
    private FindAccountInfo findProfiles(Page<Account> accountPage) {
        if (accountPage.isEmpty())
            return new FindAccountInfo().setAccounts(accountPage);

        Set<Integer> profileIds = accountPage.stream().map(Account::getProfileId).collect(Collectors.toSet());

        return new FindAccountInfo()
                .setAccounts(accountPage)
                .setProfiles(profileInternalService.findByIdIn(profileIds));
    }

    /**
     * update employee
     *
     * @param account account
     */
    private void updateEmployee(Account account) {

        Employees employees = employeeInternalService.findByIdAccount(account.getId());

        employees.setAccountId(null);

        employeeInternalService.updateAccountId(employees);

    }

    private Boolean checkOtp(OtpRequest otpRequest) {

        long expiresIn = TimeUnit.DAYS.toMillis(5);
        SessionCookieOptions options = SessionCookieOptions.builder()
                .setExpiresIn(expiresIn)
                .build();
        try {
            String accessToken = FirebaseAuth.getInstance().createSessionCookie(otpRequest.getIdToken(), options);
            FirebaseToken auth = FirebaseAuth.getInstance().verifySessionCookie(accessToken);

            String phoneRegistered = String.valueOf(auth.getClaims().get("phone_number")).trim();

            if (otpRequest.getPhone().trim().equals(phoneRegistered)) {
                return true;
            }

        } catch (FirebaseAuthException e) {
            e.printStackTrace();
        }

        return false;
    }

}
