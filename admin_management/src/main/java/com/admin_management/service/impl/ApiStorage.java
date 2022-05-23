package com.admin_management.service.impl;

import com.admin_management.model.bo.ApiList;
import com.admin_management.model.bo.DepartmentType;
import com.admin_management.model.bo.PropertiesCode;
import com.admin_management.model.bo.StatusCommon;
import com.admin_management.model.request.FilterOtherProduct;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class ApiStorage {

    private final Logger logger = LogManager.getLogger(getClass());
    /**
     * Destination Micro Service
     */

    @Value("${app.base.url.management.permission}")
    public String urlPermissionManagement;
    @Value("${app.base.url.driver}")
    public String urlDriver;
    @Value("${app.base.url.management.public}")
    public String urlPublicManagement;
    @Value("${app.base.url.management.ware-house}")
    public String urlWareHouseManagement;
    @Value("${app.base.url.management.shift-management}")
    public String urlShift;

    /**
     * Get Api check permission
     *
     * @return String
     */
    public String getApiCheckPermission() {
        String url = urlPermissionManagement + ApiList.API_CHECK_PERMISSION;
        logger.info("Call to url: " + url);
        return url;
    }

    public String getApiInsertUpdateRolesAccount() {
        String url = urlPermissionManagement + ApiList.API_SAVE_ROLES_ACCOUNT;
        logger.info("Call to url: " + url);
        return url;
    }

    public String getRoleByAccountId(String accountId) {
        String url = urlPermissionManagement + String.format(ApiList.API_GET_ROLES_ACCOUNT_ID, accountId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String deleteDriver(String accountId) {
        String url = urlDriver + String.format(ApiList.API_DELETE_DRIVER_ACCOUNT, accountId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String checkDriverExist(String accountId) {
        String url = urlDriver + String.format(ApiList.API_CHECK_DRIVER_ACCOUNT, accountId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String getProperties(PropertiesCode code, DepartmentType type) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_PROPERTIES, code, type);
        logger.info("Call to url: " + url);
        return url;
    }

    public String insertIntoMedia() {
        String url = urlPublicManagement + ApiList.API_CREATE_MEDIA_INFO;
        logger.info("call to url: " + url);
        return url;
    }

    public String getStation(int id) {
        return urlPublicManagement + String.format(ApiList.API_GET_STATION, id);
    }

    /**
     * Get Api get profile qr
     *
     * @return String
     */
    public String createEmployeeStation() {
        String url = urlPublicManagement + ApiList.API_CREATE_EMPLOYEE_STATION;
        logger.info("Call to url: " + url);
        return url;
    }

    /**
     * Get Api get profile qr
     *
     * @return String
     */
    public String getEmployeeStation(int employeeId) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_EMPLOYEE_STATION, employeeId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String getFile(int id) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_FILE, id);
        logger.info("Call to url: " + url);
        return url;
    }

    public String findDistrictByIdProvince(Integer provinceId) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_DISTRICT_BY_ID_PROVINCE, provinceId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String findWardByIdDistrict(Integer districtId) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_WARD_BY_ID_DISTRICT, districtId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String findWardById(Integer id) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_WARD_BY_ID, id);
        logger.info("Call to url: " + url);
        return url;
    }

    public String findStationById(Integer id) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_STATION_BY_ID, id);
        logger.info("Call to url: " + url);
        return url;
    }

    public String findStationByEmployeeId(Integer employeeId) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_STATION_BY_EMPLOYEE_ID, employeeId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String deleteCalendar(Integer employeeId) {
        String url = urlShift + String.format(ApiList.API_DELETE_CALENDAR, employeeId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String findEmployeeByStationName(String name) {
        if (!StringUtils.isBlank(name)) name = URLEncoder.encode(name, StandardCharsets.UTF_8);
        String url = urlPublicManagement + String.format(ApiList.API_EMPLOYEE_BY_STATION_NAME, name);
        logger.info("Call to url: " + url);
        return url;
    }

    public String findByEmployeeId(Integer employeeId) {
        String url = urlPublicManagement + String.format(ApiList.API_EMPLOYEE_BY_ID, employeeId);
        logger.info("Call to url: " + url);
        return url;
    }

    public String getQrCodesByHose() {
        String url = urlPublicManagement + ApiList.API_GET_QR_CODE_BY_HOSE;
        logger.info("Call to url: " + url);
        return url;
    }

    public String getQrCodeByOtherProduct(FilterOtherProduct filterOtherProduct) {
        String url = urlWareHouseManagement + ApiList.API_GET_QR_CODE_BY_OTHER_PRODUCT;
        url += getUrlApiGetProductQrCode(filterOtherProduct);
        logger.info("Call to url: " + url);
        return url;
    }

    private String getUrlApiGetProductQrCode(FilterOtherProduct filterOtherProduct) {

        String filterCondition = "?page=" + filterOtherProduct.getPage() + "&size=" + filterOtherProduct.getSize()
                + "&direction-sort=" + filterOtherProduct.getSortedType() + "&field-sort=" + filterOtherProduct.getSortedField();

        if (!StringUtils.isBlank(filterOtherProduct.getSearchedText()))
            filterCondition += "&search-text=" + URLEncoder.encode(filterOtherProduct.getSearchedText().toLowerCase().trim(), StandardCharsets.UTF_8);

        return filterCondition;
    }

    /**
     * call delete employee station by employee id
     * <p>
     * param qrId
     *
     * @return String
     */
    public String deleteEmployeeStationByEmployeeId(Integer qrId) {
        String url = urlPublicManagement + String.format(ApiList.API_DELETE_EMPLOYEE_STATION, qrId);
        logger.info("call to url: " + url);
        return url;
    }

    public String getStationName(Integer employeeId) {
        String url = urlPublicManagement + String.format(ApiList.GET_STATION_NAME, employeeId);
        logger.info("call to url: " + url);
        return url;
    }

    public String findByStationByEmployeeIdAndStatus(Integer employeeId, StatusCommon statusCommon) {
        String url = urlPublicManagement + String.format(ApiList.API_GET_STATION_ACTIVE_BY_EMPLOYEE_ID, employeeId);
        if (statusCommon != null) {
            return url + "&status=" + statusCommon;
        }
        logger.info("Call to url: " + url);
        return url;
    }

    public String findByEmployeeIdAndCodeAndStatus(String driverId, String orderCode, Integer employeeId) {
        return urlPublicManagement + String.format(ApiList.API_GET_BY_DRIVER_AND_CODE_AND_EMPLOYEE, driverId, orderCode, employeeId);
    }
}