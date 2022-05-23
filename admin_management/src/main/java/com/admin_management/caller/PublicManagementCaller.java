package com.admin_management.caller;

import com.admin_management.model.bo.DepartmentType;
import com.admin_management.model.bo.PropertiesCode;
import com.admin_management.model.bo.StatusCommon;
import com.admin_management.model.request.CreateEmployeeStationRequests;
import com.admin_management.model.response.*;
import com.admin_management.service.impl.ApiStorage;
import com.admin_management.util.Global;
import com.common.exception.BusinessException;
import com.common.model.response.Response;
import com.common.util.ErrorCode;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class PublicManagementCaller {

    private final RestClient restClient;
    private final ApiStorage apiStorage;

    /**
     * find department , positions
     *
     * @param code code
     * @param type type
     * @return PropertiesResponse
     */
    public PropertiesResponse getProperties(PropertiesCode code, DepartmentType type) {

        CompletableFuture<Response<PropertiesResponse>> cfProperties = restClient.get(apiStorage.getProperties(code, type), restClient.headers)
                .thenApply(httpResponse -> {
                    if (httpResponse.statusCode() != 200)
                        throw new BusinessException(ErrorCode.PROFILE_IS_NULL, "Properties with this code not exist " + code);

                    return Json.decode(httpResponse.body(), Global.propertiesReaders);
                });

        Response<PropertiesResponse> response = cfProperties.join();
        if (response == null)
            throw new BusinessException(ErrorCode.PROFILE_IS_NULL, "Properties with this code not exist " + code);

        return response.getData();
    }

    /**
     * create employee station
     *
     * @param request request
     */
    public void createEmployeeStation(CreateEmployeeStationRequests request) {
        String url = apiStorage.createEmployeeStation();
        restClient.postNHandleError
                (request, Global.employeeStationWriter, Global.employeeStationReader, url, restClient.headers).join();
    }

    /**
     * update employee station
     *
     * @param request request
     */
    public void updateEmployeeStation(CreateEmployeeStationRequests request) {
        String url = apiStorage.createEmployeeStation();
        restClient.putNHandleError
                (request, Global.employeeStationWriter, Global.employeeStationReader, url, restClient.headers);
    }

    /**
     * find station by employee id
     *
     * @param employeeId employeeId
     * @return CompletableFuture<Response < List < StationResponse>>>
     */
    public CompletableFuture<Response<List<StationResponse>>> getStationsByEmployeeId(int employeeId) {
        String url = apiStorage.getEmployeeStation(employeeId);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.stationsReader));
    }

    /**
     * get file by id
     *
     * @param id id
     * @return FileResponse
     */
    public FileResponse getFile(int id) {

        CompletableFuture<Response<FileResponse>> cfStation = restClient.get(apiStorage.getFile(id), restClient.headers)
                .thenApply(httpResponse -> {
                    if (httpResponse.statusCode() != 200)
                        throw new BusinessException(ErrorCode.FILE_NOT_EXIST, "File with this id not exist " + id);

                    return Json.decode(httpResponse.body(), Global.fileReader);
                });

        Response<FileResponse> response = cfStation.join();
        if (response == null) return null;

        return response.getData();
    }

    /**
     * Call to public Service for finding district by  id province
     *
     * @param provinceId provinceId
     */
    public CompletableFuture<Response<List<DistrictResponse>>> validateProvince(Integer provinceId) {

        String url = apiStorage.findDistrictByIdProvince(provinceId);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.districtReader));
    }

    /**
     * Call to public Service for finding ward by  id district
     *
     * @param districtId districtId
     */

    public CompletableFuture<Response<List<WardResponse>>> validateDistrict(Integer districtId) {

        String url = apiStorage.findWardByIdDistrict(districtId);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.wardsReader));
    }

    /**
     * Call to public Service for finding ward by  id
     *
     * @param id id
     */
    public CompletableFuture<Response<WardResponse>> validateWard(Integer id) {

        String url = apiStorage.findWardById(id);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.wardReader));
    }

    /**
     * Call to public Service for finding stations by  id
     *
     * @param id id
     */
    public CompletableFuture<Response<StationResponse>> validateStation(Integer id) {

        String url = apiStorage.findStationById(id);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.stationReader));
    }

    /**
     * Call to public Service for finding StationResponse by  id province
     *
     * @param employeeId employeeId
     */
    public CompletableFuture<Response<List<StationResponse>>> findStationByEmployeeId(Integer employeeId) {

        String url = apiStorage.findStationByEmployeeId(employeeId);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.stationListReader));
    }

    /**
     * Call to public Service for calendar by employee
     *
     * @param employeeId employeeId
     */
    public void deleteCalendars(Integer employeeId) {

        String url = apiStorage.deleteCalendar(employeeId);
        restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.employeeStationReader));
    }


    /**
     * Call to public Service for finding EmployeeResponse by  id name
     *
     * @param name name
     */
    public CompletableFuture<Response<List<EmployeeResponse>>> findEmployeeByStationName(String name) {

        String url = apiStorage.findEmployeeByStationName(name);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.employeeReader));
    }

    /**
     * Call to public Service for finding StationResponse by  id employee
     *
     * @param employeeId employeeId
     */
    public CompletableFuture<Response<List<EmployeeResponse>>> findByEmployeeId(Integer employeeId) {

        String url = apiStorage.findByEmployeeId(employeeId);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.employeeReader));
    }

    /**
     * delete employee station by employee id
     *
     * @param employeeId employeeId
     */
    public void deleteEmployeeStationByEmployeeId(Integer employeeId) {
        String url = apiStorage.deleteEmployeeStationByEmployeeId(employeeId);
        restClient.delete(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.booleanReader));
    }

    /**
     * Call to public Service for finding StationResponse by  id province
     *
     * @param employeeId employeeId
     */
    public CompletableFuture<Response<List<StationResponse>>> findByStationByEmployeeIdAndStatus(Integer employeeId, StatusCommon statusCommon) {

        String url = apiStorage.findByStationByEmployeeIdAndStatus(employeeId, statusCommon);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.stationListReader));
    }

    /**
     * Call to public Service for finding StationResponse by  id province
     *
     * @param employeeId employeeId
     */
    public CompletableFuture<Response<Boolean>> findByEmployeeIdAndCodeAndStatus(String driverId, String orderCode, Integer employeeId) {

        String url = apiStorage.findByEmployeeIdAndCodeAndStatus(driverId, orderCode, employeeId);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.checkDriver));
    }
}
