package com.admin_management.mapper;

import com.admin_management.caller.PublicManagementCaller;
import com.admin_management.model.bo.CredentialImages;
import com.admin_management.model.bo.EmployeeStatus;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.request.*;
import com.admin_management.model.response.*;
import com.admin_management.service.SequenceInternalService;
import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeMapper {

    private final SequenceInternalService service;
    private final PublicManagementCaller caller;

    /**
     * map employees to DetailEmployeeResponse
     *
     * @param employees employees
     * @return DetailEmployeeResponse
     */
    public DetailEmployeeResponse mapToDetail(Employees employees) {
        return new DetailEmployeeResponse()
                .setName(employees.getName())
                .setPosition(employees.getPositions())
                .setAccountId(employees.getAccountId())
                .setEmployeeId(employees.getId())
                .setDepartment(employees.getDepartment())
                .setCode(employees.getCode());
    }

    /**
     * map CreateEmployeeRequest to Employees
     *
     * @param request request
     * @return Employees
     */
    public Employees map(CreateEmployeeRequest request) {
        Employees employees = commonMap(new Employees(), request);

        employees.setCode(service.generateEmployeeCode());
        employees.setStatus(EmployeeStatus.ACTIVE);

        return employees;
    }

    /**
     * map request to Employees
     *
     * @param employees employees
     * @param request request
     * @return Employees
     */
    public Employees map(Employees employees, UpdateEmployeeRequest request) {
        return commonMap(employees, request);
    }

    /**
     * map UpsertEmployeeRequest to Employees
     *
     * @param employees employees
     * @param request request
     * @return Employees
     */
    public Employees commonMap(Employees employees, UpsertEmployeeRequest request) {
        employees.setName(request.getName());
        employees.setAvatar(request.getAvatar());
        employees.setDateOfBirth(request.getDateOfBirth() != null ? request.getDateOfBirth().toInstant().atOffset(ZoneOffset.UTC) : null);
        employees.setSex(request.getSex());
        employees.setPhone(request.getPhone());
        employees.setEmail(request.getEmail());
        employees.setDepartment(caller.getProperties(request.getDepartment().getCode(), request.getDepartment().getDepartmentType()));
        employees.setPositions(caller.getProperties(request.getPositions().getCode(), request.getPositions().getDepartmentType()));
        employees.setNation(request.getNation());
        employees.setReligion(request.getReligion());
        employees.setAddress(request.getAddress());
        employees.setIdentityCardNumber(request.getIdentityCardNumber());
        employees.setDateRange(request.getDateRange() != null ? request.getDateRange().toInstant().atOffset(ZoneOffset.UTC) : null);
        employees.setFullAddress(request.getFullAddress());
        employees.setSupplyAddress(request.getSupplyAddress());
        employees.setProvince(request.getProvince());
        employees.setDistrict(request.getDistrict());
        employees.setWard(request.getWard());
        employees.setMaritalStatus(request.getMaritalStatus());
        checkCredentialImages(request.getCredentialImages(), employees);
        checkFile(request.getAttachmentIds(), employees);

        return employees;
    }

    /**
     * Map Employees to EmployeeInfo
     *
     * @return employees
     */
    public EmployeeInfo map(Employees employees) {

        return new EmployeeInfo()
                .setId(employees.getId())
                .setCode(employees.getCode())
                .setName(employees.getName())
                .setDepartment(employees.getDepartment())
                .setPositions(employees.getPositions());
    }

    /**
     * Map employees to EmployeeResponse
     *
     * @RequestBody employees
     */
    public EmployeeResponse mapTo(Employees employees) {

        return new EmployeeResponse()
                .setId(employees.getId())
                .setPositionName(employees.getPositions().getName())
                .setName(employees.getName())
                .setCode(employees.getCode());
    }

    /**
     * Map List<Category> to List<CategoryResponse>
     *
     * @return List of CategoryResponse
     */
    public List<EmployeeResponse> mapTo(List<Employees> employees) {
        return employees.stream().map(this::mapTo).collect(Collectors.toList());
    }

    /**
     * Map AccountInfoOfCustomer Response from Account ,DriverDetail
     *
     * @param employees employees
     * @param stationResponses stationResponses
     * @return AccountInfoOfCustomer
     */
    public EmployeeInfo mapResponse(Employees employees, List<StationResponse> stationResponses) {

        EmployeeInfo employeeInfo = new EmployeeInfo();
        employeeInfo.setId(employees.getId());
        employeeInfo.setDepartment(employees.getDepartment());
        employeeInfo.setPositions(employees.getPositions());
        employeeInfo.setCode(employees.getCode());
        employeeInfo.setName(employees.getName());
        employeeInfo.setStation(stationResponses);

        return employeeInfo;
    }

    /**
     * map employees to CreateEmployeeStationRequests
     *
     * @param stationId stationId
     * @param employees employees
     * @return CreateEmployeeStationRequests
     */
    public CreateEmployeeStationRequests map(List<Integer> stationId, Employees employees) {
        List<CreateEmployeeStationRequest> responseList = new ArrayList<>();

        if (stationId == null) {
            CreateEmployeeStationRequest request = new CreateEmployeeStationRequest();
            request.setEmployeeId(employees.getId());
            responseList.add(request);
        }
        if (stationId != null) {
            stationId.forEach(it -> {
                CreateEmployeeStationRequest request = new CreateEmployeeStationRequest();
                request.setStationId(it);
                request.setEmployeeId(employees.getId());
                responseList.add(request);
            });
        }
        CreateEmployeeStationRequests requests = new CreateEmployeeStationRequests();
        requests.setCreateEmployeeStationRequests(responseList);
        return requests;
    }

    /**
     * map employee to employeeDetail
     *
     * @param employees employees
     * @return EmployeeDetail
     */
    public EmployeeDetail mapDTO(Employees employees, List<StationResponse> stationResponses) {
        return new EmployeeDetail().setId(employees.getId())
                .setAvatar(employees.getAvatar())
                .setCode(employees.getCode())
                .setName(employees.getName())
                .setDateOfBirth(employees.getDateOfBirth())
                .setSex(employees.getSex())
                .setPhone(employees.getPhone())
                .setEmail(employees.getEmail())
                .setDepartment(employees.getDepartment())
                .setPositions(employees.getPositions())
                .setAccountId(employees.getAccountId())
                .setReligion(employees.getReligion())
                .setAddress(employees.getAddress())
                .setIdentityCardNumber(employees.getIdentityCardNumber())
                .setDateRange(employees.getDateRange())
                .setFullAddress(employees.getFullAddress())
                .setSupplyAddress(employees.getSupplyAddress())
                .setProvince(employees.getProvince())
                .setDistrict(employees.getDistrict())
                .setWard(employees.getWard())
                .setMaritalStatus(employees.getMaritalStatus())
                .setCredentialImages(employees.getCredentialImages())
                .setAttachment(employees.getAttachment())
                .setStationList(stationResponses)
                .setNation(employees.getNation());
    }

    /**
     * map List<CredentialImagesRequest> to CredentialImage employee
     *
     * @param infoRequests infoRequests
     * @param employees employees
     */
    private void checkCredentialImages(List<CredentialImagesRequest> infoRequests, Employees employees) {
        List<CredentialImages> responseList = new ArrayList<>();
        infoRequests.forEach(it -> {

            CredentialImages credentialImages = new CredentialImages();
            credentialImages.setId(it.getId());
            credentialImages.setUrl(it.getUrl());
            credentialImages.setType(it.getType());
            credentialImages.setFace(it.getFace());
            credentialImages.setName(it.getName());


            responseList.add(credentialImages);
        });
        employees.setCredentialImages(responseList);
    }

    /**
     * check file
     *
     * @param fileIds fileIds
     * @param employees employees
     */
    private void checkFile(Set<Integer> fileIds, Employees employees) {
        List<FileResponse> responseList = new ArrayList<>();
        fileIds.forEach(it -> {

            FileResponse fileResponse = caller.getFile(it);
            if (fileResponse == null)
                throw new BusinessException(ErrorCode.FILE_NOT_EXIST, ErrorMessage.FILE_NOT_FOUND);
            responseList.add(fileResponse);
        });
        employees.setAttachment(responseList);
    }
}
