package com.admin_management.service.impl;

import com.admin_management.mapper.ProfileMapper;
import com.admin_management.model.entity.Account;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.entity.Profile;
import com.admin_management.model.request.AvatarRequest;
import com.admin_management.model.response.ProfileResponse;
import com.admin_management.repository.ProfileRepository;
import com.admin_management.service.ProfileService;
import com.common.exception.BusinessException;
import com.common.model.bo.AccountStatus;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository repository;
    private final AccountInternalServiceImpl accountInternalService;
    private final EmployeeInternalServiceImpl employeeInternalService;
    private final ProfileMapper mapper;


    @Override
    public ProfileResponse findProfileById(String accountId, Boolean checkApp) {
        Account account = accountInternalService.findByIdAndStatus(accountId, AccountStatus.DELETE);

        Profile profile = repository.findById(account.getProfileId())
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.PROFILE_NOT_FOUND, String.format(ErrorMessage.PROFILE_NOT_FOUND, account.getProfileId())));

        Employees employees = employeeInternalService.findByIdAccount(accountId);

        return mapper.map(profile, account, employees, checkApp);
    }

    /**
     * Api update avatar
     *
     * @param accountId
     * @param avatarRequest
     * @return
     */
    @Override
    public Boolean updateAvatar(String accountId, AvatarRequest avatarRequest) {

        Account account = accountInternalService.findByIdAndStatus(accountId, AccountStatus.DELETE);

        Profile profile = repository.findById(account.getProfileId())
                .orElseThrow(() -> new BusinessException
                        (ErrorCode.PROFILE_NOT_FOUND, String.format(ErrorMessage.PROFILE_NOT_FOUND, account.getProfileId())));

        profile.setAvatar(avatarRequest.getAvatar());

        repository.update(profile);

        return true;
    }
}
