package com.admin_management.service.impl;

import com.admin_management.caller.PublicManagementCaller;
import com.admin_management.mapper.EmployeeMapper;
import com.admin_management.model.bo.EmployeeStatus;
import com.admin_management.model.bo.StatusCommon;
import com.admin_management.model.entity.Account;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.request.*;
import com.admin_management.model.response.*;
import com.admin_management.repository.EmployeeRepository;
import com.admin_management.service.AccountInternalService;
import com.admin_management.service.EmployeeInternalService;
import com.admin_management.service.EmployeeService;
import com.admin_management.service.ProfileInternalService;
import com.admin_management.util.Global;
import com.admin_management.validator.EmployeeValidator;
import com.common.exception.BusinessException;
import com.common.model.bo.AccountStatus;
import com.common.service.impl.OtpServiceImpl;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final ProfileInternalService profileInternalService;
    private final OtpServiceImpl otpService;
    private final EmployeeMapper mapper;
    private final EmployeeValidator validator;
    private final PublicManagementCaller publicManagementCaller;
    private final AccountInternalService accountInternalService;
    private final EmployeeInternalService employeeInternalService;

    /**
     * find  employee by filter , sort , searchText ,page
     * <p>
     * param filterEmployeeRequest
     * param searchText
     * param field
     * param direction
     *
     * @return EmployeeInfo
     */
    @Override
    public Page<EmployeeInfo> employeeFilter(FilterEmployeeRequest filterEmployeeRequest, String searchText, String field, Sort.Direction direction) {

        Pageable pageable = PageRequest.of(filterEmployeeRequest.getPage(), filterEmployeeRequest.getSize(), Sort.by(direction, field));

        if (StringUtils.isEmpty(searchText) || searchText.trim().equals("null")) {

            List<Employees> employees = repository.findAll(getEmployeeFilter(filterEmployeeRequest), Sort.by(direction, field));

            List<EmployeeInfo> employeeInfos = employees.stream().
                    map(it -> mapper.mapResponse(it, publicManagementCaller.findStationByEmployeeId(it.getId()).join().getData()))
                    .collect(Collectors.toList());

            return createPageFromList(employeeInfos, pageable);
        }
        return findEmployeeBySearchText(searchText, filterEmployeeRequest, field, direction, pageable);
    }

    /**
     * find all employee
     *
     * @return EmployeeResponse
     */
    @Override
    public List<EmployeeResponse> findAllEmployee() {

        List<Employees> employees = repository.findByStatusAndAccountIdOrderByCreatedAtDesc(EmployeeStatus.ACTIVE, null);

        return mapper.mapTo(employees);
    }

    /**
     * find employee id
     * <p>
     * param employeeId
     *
     * @return EmployeeDetail
     */
    @Override
    public EmployeeDetail findByEmployeeId(int employeeId) {
        Employees employees = repository.findById(employeeId)
                .orElseThrow(() -> new BusinessException(ErrorCode.EMPLOYEE_NOT_EXIST,
                        String.format(ErrorMessage.EMPLOYEE_NOT_EXIST, employeeId)));

        List<StationResponse> stationResponses = publicManagementCaller.getStationsByEmployeeId(employeeId).join().getData();

        return mapper.mapDTO(employees, stationResponses);
    }

    /**
     * Get employee detail
     *
     * @return DetailEmployeeResponse
     */
    public DetailEmployeeResponse findDetailByAccountId(String accountId) {
        Employees employees = repository.findByAccountId(accountId);
        if (employees == null) return null;

        accountInternalService.findByIdAndStatus(accountId, AccountStatus.ACTIVE, "Account with id " + accountId + " not found");

        return mapper.mapToDetail(employees);
    }

    /**
     * create employee
     * <p>
     * param request
     *
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(CreateEmployeeRequest request) {

        validator.validate(request);

        Employees employees = mapper.map(request);

        repository.insert(employees);

        CreateEmployeeStationRequests requestList = mapper.map(request.getStationIds(), employees);

        publicManagementCaller.createEmployeeStation(requestList);

        return true;
    }

    /**
     * update employee by id
     * <p>
     * param id
     * param request
     *
     * @return Boolean
     */
    @Override
    public Boolean update(Integer id, UpdateEmployeeRequest request) {

        Employees employees = validator.validate(id, request);

        employees = mapper.map(employees, request);

        repository.update(employees);

        if (employees.getAccountId() != null) {

            Account account = accountInternalService.findByIdAndStatus(employees.getAccountId(), AccountStatus.DELETE);

            profileInternalService.update(account.getProfileId(), employees);
        }

        CreateEmployeeStationRequests requestList = mapper.map(request.getStationIds(), employees);
        publicManagementCaller.updateEmployeeStation(requestList);

        return true;
    }

    /**
     * delete employee by id
     * <p>
     * param id
     *
     * @return Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Integer id) {

        Employees employees = repository.findById(id).orElseThrow(() ->
                new BusinessException(ErrorCode.EMPLOYEE_NOT_EXIST, String.format(ErrorMessage.EMPLOYEE_NOT_EXIST, id)));

        repository.deleteEmployees(id);

        publicManagementCaller.deleteEmployeeStationByEmployeeId(id);

        if (employees.getAccountId() != null)
            deleteAccount(employees);

        deleteCalendar(id);

        return true;
    }

    @Override
    public List<String> getAccountIdsByEmployeeIds(List<Integer> employeeIds) {
        return employeeInternalService.findAccountIdsByEmployeeIds(employeeIds);
    }

    /**
     * find employee by id
     * <p>
     * param request
     *
     * @return List<EmployeeResponse>
     */
    @Override
    public List<EmployeeResponse> findById(EmployeeIdRequest request) {

        List<Employees> employees = repository.findByIdInAndStatus(request.getEmployeeIds(), EmployeeStatus.ACTIVE);

        return mapper.mapTo(employees);
    }

    @Override
    public List<EmployeeResponse> findByDepartmentShippingTeam() {

        List<Employees> employees = repository.findByDepartmentShippingTeam();

        return mapper.mapTo(employees);
    }

    /**
     * finding StationResponse by  id accountId
     * <p>
     * param accountId
     *
     * @return List<StationResponse>
     */
    @Override
    public List<StationResponse> findByEmployeeId(String accountId) {

        Employees employees = repository.findByAccountId(accountId);
        if (employees == null) return new ArrayList<>();

        return publicManagementCaller.findStationByEmployeeId(employees.getId()).join().getData();
    }

    @Override
    public List<StationResponse> findByStationByEmployeeIdAndStatus(String accountId, StatusCommon statusCommon) {

        Employees employees = repository.findByAccountId(accountId);
        if (employees == null) return new ArrayList<>();

        return publicManagementCaller.findByStationByEmployeeIdAndStatus(employees.getId(), statusCommon).join().getData();
    }

    /**
     * find employee by accountId token
     * <p>
     * param accountId
     *
     * @return List<EmployeeResponse>
     */
    @Override
    public List<EmployeeResponse> findByEmployeeByEmployeeId(String accountId) {

        Employees employees = repository.findByAccountId(accountId);
        if (employees == null) return new ArrayList<>();
        List<EmployeeResponse> responseList = publicManagementCaller.findByEmployeeId(employees.getId()).join().getData();
        List<Integer> ids = responseList.stream().map(EmployeeResponse::getId).collect(Collectors.toList());

        List<Employees> employeesList = repository.findByIdIn(ids);



        return mapper.mapTo(employeesList);
    }

    /**
     * find employee by id
     * caller internal service
     * <p>
     * param employeeId
     *
     * @return EmployeeResponse
     */
    @Override
    public EmployeeResponse findEmployeeById(int employeeId) {

        Employees employees = repository.findByIdAndStatus(employeeId, EmployeeStatus.ACTIVE).orElse(new Employees());

        return mapper.mapTo(employees);
    }

    /**
     * find employee case searchText
     * <p>
     * param searchText
     * param filterEmployeeRequest
     * param field
     * param direction
     * param pageable
     *
     * @return Page<EmployeeInfo>
     */
    private Page<EmployeeInfo> findEmployeeBySearchText(String searchText, FilterEmployeeRequest filterEmployeeRequest,
                                                        String field, Sort.Direction direction, Pageable pageable) {

        searchText = "%" + searchText.toLowerCase().trim() + "%";
        List<Employees> employeesList = repository.findEmployeeBySearchText(searchText);
        List<Employees> listEmployee = findEmployeeByStation(searchText);
        List<Employees> employees = repository.findAll(getEmployeeFilter(filterEmployeeRequest), Sort.by(direction, field));
        Map<Integer, Employees> map = employeesList.stream().collect(Collectors.toMap(Employees::getId, Function.identity()));
        Map<Integer, Employees> mapTo = listEmployee.stream().collect(Collectors.toMap(Employees::getId, Function.identity()));
        if (employeesList.isEmpty()) {

            List<Employees> employeeInfo = findEmployeeInfo(employees, mapTo);
            List<EmployeeInfo> employeeResponse = employeeInfo.stream().
                    map(it -> mapper.mapResponse(it, publicManagementCaller.findStationByEmployeeId(it.getId()).join().getData()))
                    .collect(Collectors.toList());
            return createPageFromList(employeeResponse, pageable);
        }
        List<Employees> employeeInfo = findEmployeeInfo(employees, map);

        List<EmployeeInfo> employeeResponse = employeeInfo.stream().
                map(it -> mapper.mapResponse(it, publicManagementCaller.findStationByEmployeeId(it.getId()).join().getData()))
                .collect(Collectors.toList());

        return createPageFromList(employeeResponse, pageable);
    }

    private List<Employees> findEmployeeInfo(List<Employees> employees, Map<Integer, Employees> map) {

        return employees.stream().filter(it -> map.get(it.getId()) != null).collect(Collectors.toList());
    }

    /**
     * find employee station by searchText
     * <p>
     * param searchText
     *
     * @return List<Employees>
     */
    private List<Employees> findEmployeeByStation(String searchText) {

        List<EmployeeResponse> responseList = publicManagementCaller.findEmployeeByStationName(searchText).join().getData();
        List<Integer> ids = responseList.stream().map(EmployeeResponse::getId).collect(Collectors.toList());

        return repository.findByIdIn(ids);
    }

    /**
     * filter employee by status ,department,positions
     * <p>
     * param filterEmployeeRequest
     *
     * @return Specification<Employees>
     */
    private Specification<Employees> getEmployeeFilter(FilterEmployeeRequest filterEmployeeRequest) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.equal(root.get("status"), EmployeeStatus.ACTIVE));

            if (filterEmployeeRequest.getDepartment() != null) {
                Predicate predicateDepartment =
                        (criteriaBuilder.function(Global.getFunctionPostgres,
                                String.class, root.get("department"),
                                criteriaBuilder.literal("id").as(String.class))).in(filterEmployeeRequest.getDepartment().toString());
                predicates.add(predicateDepartment);
            }
            if (filterEmployeeRequest.getPositions() != null) {
                Predicate predicatePositions =
                        (criteriaBuilder.function(Global.getFunctionPostgres,
                                String.class, root.get("positions"),
                                criteriaBuilder.literal("id").as(String.class))).in(filterEmployeeRequest.getPositions().toString());
                predicates.add(predicatePositions);
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    /**
     * create page from list
     * <p>
     * param list
     * param pageable
     * param <T>
     *
     * @return <T> Page<T>
     */
    private <T> Page<T> createPageFromList(List<T> list, Pageable pageable) {
        if (list == null)
            throw new IllegalArgumentException("To create a Page, the list mustn't be null!");

        int startOfPage = pageable.getPageNumber() * pageable.getPageSize();
        if (startOfPage > list.size())
            return new PageImpl<>(new ArrayList<>(), pageable, 0);

        int endOfPage = Math.min(startOfPage + pageable.getPageSize(), list.size());
        return new PageImpl<>(list.subList(startOfPage, endOfPage), pageable, list.size());
    }

    /**
     * delete account of employee
     * <p>
     * param employees
     */
    private void deleteAccount(Employees employees) {

        accountInternalService.deleteAccount(employees.getAccountId());

        otpService.revokeLoginSession(employees.getAccountId());
    }

    private void deleteCalendar(Integer employeeId) {
        publicManagementCaller.deleteCalendars(employeeId);
    }
}
