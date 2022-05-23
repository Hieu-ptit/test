package com.admin_management.service;

import com.admin_management.model.bo.StatusCommon;
import com.admin_management.model.request.CreateEmployeeRequest;
import com.admin_management.model.request.EmployeeIdRequest;
import com.admin_management.model.request.FilterEmployeeRequest;
import com.admin_management.model.request.UpdateEmployeeRequest;
import com.admin_management.model.response.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeService {

    Page<EmployeeInfo> employeeFilter(FilterEmployeeRequest filterEmployeeRequest, String searchText, String field, Sort.Direction direction);

    List<EmployeeResponse> findAllEmployee();

    EmployeeDetail findByEmployeeId(int employeeId);

    DetailEmployeeResponse findDetailByAccountId(String accountId);

    List<EmployeeResponse> findById(EmployeeIdRequest request);

    List<EmployeeResponse> findByDepartmentShippingTeam();

    List<StationResponse> findByEmployeeId(String accountId);

    List<StationResponse> findByStationByEmployeeIdAndStatus(String accountId, StatusCommon statusCommon);

    List<EmployeeResponse> findByEmployeeByEmployeeId(String accountId);

    EmployeeResponse findEmployeeById(int employeeId);

    Boolean create(CreateEmployeeRequest request);

    Boolean update(Integer id, UpdateEmployeeRequest request);

    Boolean delete(Integer id);

    List<String> getAccountIdsByEmployeeIds(List<Integer> employeeIds);
}
