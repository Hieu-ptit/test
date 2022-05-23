package com.admin_management.controller;

import com.admin_management.model.bo.StatusCommon;
import com.admin_management.model.request.CreateEmployeeRequest;
import com.admin_management.model.request.EmployeeIdRequest;
import com.admin_management.model.request.FilterEmployeeRequest;
import com.admin_management.model.request.UpdateEmployeeRequest;
import com.admin_management.model.response.DetailEmployeeResponse;
import com.admin_management.model.response.EmployeeDetail;
import com.admin_management.model.response.EmployeeResponse;
import com.admin_management.model.response.StationResponse;
import com.admin_management.service.EmployeeService;
import com.admin_management.service.impl.InfoInJwt;
import com.admin_management.util.Global;
import com.common.exception.BusinessException;
import com.common.model.response.Response;
import com.common.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/employees")
@Validated
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;
    private final InfoInJwt infoInJwt;

    @GetMapping
    public Response<?> EmployeeFilter(
            @Length(max = 99, message = "4158")
            @RequestParam(value = "search-text", required = false) String searchText,
            @RequestParam(value = "department-id", required = false) Integer departmentId,
            @RequestParam(value = "positions-id", required = false) Integer positionsId,
            @RequestParam(value = "direction-sort", defaultValue = "DESC") Sort.Direction direction,
            @RequestParam(value = "field-sort", defaultValue = "createdAt") String field,
            @Min(value = 1, message = "4156")
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @Min(value = 0, message = "4157")
            @RequestParam(value = "size", defaultValue = "100") Integer size) {
        if (!StringUtils.isEmpty(field) && !Global.fieldSortEmployee.contains(field))
            throw new BusinessException(ErrorCode.FIELD_SORT_INVALID, "Field sort: " + field + " invalid !");
        FilterEmployeeRequest filterEmployee = new FilterEmployeeRequest();
        filterEmployee.setDepartment(departmentId);
        filterEmployee.setPositions(positionsId);
        filterEmployee.setPage(page - 1);
        filterEmployee.setSize(size);

        return Response.ofSucceeded(service.employeeFilter(filterEmployee, searchText, field, direction));
    }

    @GetMapping("/staff")
    public Response<List<EmployeeResponse>> findAllEmployee() {
        return Response.ofSucceeded(service.findAllEmployee());
    }

    @GetMapping("/shipping-team")
    public Response<List<EmployeeResponse>> findByDepartmentShippingTeam() {
        return Response.ofSucceeded(service.findByDepartmentShippingTeam());
    }

    @GetMapping("/details/{id}")
    public Response<EmployeeDetail> findByEmployeeId(@Min(value = 0, message = "") @PathVariable("id") int employeeId) {
        return Response.ofSucceeded(service.findByEmployeeId(employeeId));
    }

    @GetMapping("/details")
    public Response<DetailEmployeeResponse> findByAccountId(@RequestParam("accountId") String accountId) {
        return Response.ofSucceeded(service.findDetailByAccountId(accountId));
    }

    @GetMapping("/station")
    public Response<List<StationResponse>> findByStationByEmployeeId(@RequestHeader("Authorization") String token) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.findByEmployeeId(accountId));
    }

    @GetMapping("/station-status")
    public Response<List<StationResponse>> findByStationByEmployeeIdAndStatus(@RequestHeader("Authorization") String token,
                                                                              @RequestParam(value = "status", required = false) StatusCommon status) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.findByStationByEmployeeIdAndStatus(accountId, status));
    }

    @GetMapping("/stations-employee")
    public Response<List<EmployeeResponse>> findByEmployeeByEmployeeId(@RequestHeader("Authorization") String token) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.findByEmployeeByEmployeeId(accountId));
    }

    /**
     * caller internal service
     *
     * @param employeeId employeeId
     * @return Response<EmployeeResponse>
     */
    @GetMapping("/responses/{employeeId}")
    public Response<EmployeeResponse> findEmployeeById(@Min(value = 0, message = "") @PathVariable("employeeId") int employeeId) {
        return Response.ofSucceeded(service.findEmployeeById(employeeId));
    }

    /**
     * call service shift
     *
     * @param employeeIds employeeIds
     * @return Response<List < String>>
     */
    @GetMapping("/accounts")
    public Response<List<String>> getAccountIdsByEmployeeIds(@RequestParam(value = "employee-ids") List<Integer> employeeIds) {
        return Response.ofSucceeded(service.getAccountIdsByEmployeeIds(employeeIds));
    }

    @PostMapping
    public Response<Boolean> create(@Valid @RequestBody CreateEmployeeRequest request) {
        return Response.ofSucceeded(service.create(request));
    }

    @PostMapping("/station")
    public Response<List<EmployeeResponse>> findById(@Valid @RequestBody EmployeeIdRequest request) {
        return Response.ofSucceeded(service.findById(request));
    }

    @PutMapping("/{id}")
    public Response<Boolean> update(@NotNull(message = "4024") @Min(value = 0, message = "4159") @PathVariable(value = "id") Integer id,
                                    @Valid @RequestBody UpdateEmployeeRequest request) {
        return Response.ofSucceeded(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public Response<Boolean> delete(@Min(value = 0, message = "4252") @PathVariable("id") Integer id) {
        return Response.ofSucceeded(service.delete(id));
    }
}
