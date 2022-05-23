package com.admin_management.validator;

import com.admin_management.caller.PublicManagementCaller;
import com.admin_management.model.bo.EmployeeStatus;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.request.CreateEmployeeRequest;
import com.admin_management.model.request.UpdateEmployeeRequest;
import com.admin_management.model.request.UpsertEmployeeRequest;
import com.admin_management.model.response.DistrictResponse;
import com.admin_management.model.response.StationResponse;
import com.admin_management.model.response.WardResponse;
import com.admin_management.repository.EmployeeRepository;
import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EmployeeValidator {

    private final PublicManagementCaller caller;
    private final EmployeeRepository repository;


    /**
     * Validate create employee
     *
     * @param request
     * @return
     */
    public void validate(CreateEmployeeRequest request) {

        if (repository.existsByPhoneAndStatusNot(request.getPhone(), EmployeeStatus.DELETE))
            throw new BusinessException(ErrorCode.ACCOUNT_NOT_FOUND_OR_PHONE_NUMBER_EXITS, String.format(ErrorMessage.PHONE_EXIST, request.getPhone()));

        if (repository.existsByIdentityCardNumberAndStatusNot(request.getIdentityCardNumber(), EmployeeStatus.DELETE))
            throw new BusinessException(ErrorCode.ID_NUMBER_EXIST, String.format(ErrorMessage.ID_NUMBER_EXIST, request.getIdentityCardNumber()));

        commonValidate(request);

    }

    /**
     * Validate update employee
     *
     * @param id
     * @param request
     * @return
     */
    public Employees validate(Integer id, UpdateEmployeeRequest request) {

        Employees employees = repository.findById(id).orElseThrow(() ->
                new BusinessException(ErrorCode.EMPLOYEE_NOT_EXIST, ErrorCode.EMPLOYEE_NOT_EXIST.getMessage()));

        if (!request.getPhone().equals(employees.getPhone()))
            if (repository.existsByPhoneAndStatusNot(request.getPhone(), EmployeeStatus.DELETE))
                throw new BusinessException(ErrorCode.ACCOUNT_NOT_FOUND_OR_PHONE_NUMBER_EXITS, String.format(ErrorMessage.PHONE_EXIST, request.getPhone()));

        if (!request.getIdentityCardNumber().equals(employees.getIdentityCardNumber()))
            if (repository.existsByIdentityCardNumberAndStatusNot(request.getIdentityCardNumber(), EmployeeStatus.DELETE))
                throw new BusinessException(ErrorCode.ID_NUMBER_EXIST, String.format(ErrorMessage.ID_NUMBER_EXIST, request.getIdentityCardNumber()));

        commonValidate(request);

        return employees;
    }

    /**
     * Validate upsert employee
     *
     * @param request
     * @return
     */
    private void commonValidate(UpsertEmployeeRequest request) {

        if (request.getProvince() != null) {
            List<DistrictResponse> districtResponses = caller.validateProvince(request.getProvince().getId()).join().getData();

            if (districtResponses == null)
                throw new BusinessException(ErrorCode.PROVINCE_NOT_FOUND, String.format(ErrorMessage.PROVINCE_NOT_FOUND, request.getDistrict()));

            List<WardResponse> wardResponses = caller.validateDistrict(request.getDistrict().getId()).join().getData();
            if (wardResponses == null)
                throw new BusinessException(ErrorCode.DISTRICT_NOT_FOUND, String.format(ErrorMessage.DISTRICT_NOT_FOUND, request.getWard()));

            WardResponse wardResponse = caller.validateWard(request.getWard().getId()).join().getData();
            if (wardResponse == null)
                throw new BusinessException(ErrorCode.WARD_NOT_FOUND, String.format(ErrorMessage.WARD_NOT_FOUND, request.getWard()));
        }
        if (request.getStationIds() != null) {
            request.getStationIds().forEach(it -> {
                if (it != 0) {
                    StationResponse stationResponse = caller.validateStation(it).join().getData();
                    if (stationResponse == null)
                        throw new BusinessException(ErrorCode.GAS_STATION_NOT_FOUND, String.format(ErrorMessage.GAS_STATION_NOT_FOUND, it));
                }
            });
        }

    }

}
