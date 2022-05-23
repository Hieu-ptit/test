package com.auth_management.service.impl;

import com.common.exception.BusinessException;
import com.common.model.API;
import com.common.model.ApiList;
import com.common.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ApiDistribute {

    /**
     * Destination Micro Service
     */
    @Value("${app.base.url.driver}")
    public String urlDriver;
    @Value("${app.base.url.enterprise}")
    public String urlEnterprise;
    @Value("${app.base.url.management.pay}")
    public String urlPay;
    @Value("${app.base.url.management.admin}")
    public String urlAdminManagement;
    @Value("${app.base.url.management.public}")
    public String urlPublicManagement;
    @Value("${app.base.url.management.ware-house}")
    public String urlWareHouseManagement;
    @Value("${app.base.url.management.permission}")
    public String urlPermissionManagement;
    @Value("${app.base.url.management.contract_debt}")
    public String urlContractDebt;
    @Value("${app.base.url.management.report_statistical}")
    public String urlReportStatistical;
    @Value("${app.base.url.management.shift_management}")
    public String urlShift;
    @Value("${app.base.url.notify_service}")
    public String urlNotify;


    /**
     * This Map contains Key is Endpoint and Value is destination micro service
     * order for distributing request
     */
    public static Map<String, String> apiForBaseUriMap = new HashMap<>();

    /**
     * Contains APIs is special (path contains Path variable, ...)
     * API object have PathRegex for saving special Path pattern, and BaseUri is base uri of this special API
     */

    public static List<API> apiSpecial = Arrays.asList(
            API.with("^/drivers/abc/xyz/", "/drivers/abc/xyz/{id}"),
            API.with("^/drivers/abc/xyz/t/", "/drivers/abc/xyz/t/{id}"),
            API.with("^/management/gas-fields/(.*)", ApiList.API_DELETE_GAS_FIELD_BY_ID_IN_MANAGEMENT),
            API.with("^/management/pump-poles/(.*)", ApiList.API_DELETE_GAS_PUMP_POLE_BY_ID_IN_MANAGEMENT),
            API.with("^/management/gas-stations/(.*)", ApiList.API_DELETE_GAS_STATION_BY_ID_IN_MANAGEMENT),
            API.with("^/management/gas-stations/(.*)", ApiList.API_DELETE_CATEGORY_BY_ID_IN_MANAGEMENT),
            API.with("^/management/pump-hoses/(.*)", ApiList.API_UPDATE_PUMP_HOSE),
            API.with("^/management/categories/(.*)", ApiList.API_DELETE_CATEGORY),
            API.with("^/management/gas-fields/(.*)", ApiList.API_UPDATE_GAS_FIELD),
            API.with("^/management/pump-poles/(.*)", ApiList.API_UPDATE_PUMP_POLE),
            API.with("^/management/orders/actuality-pay/(.*)", ApiList.API_GET_ORDER_ACTUALITY),
            API.with("^/management/orders/(.*)", ApiList.API_GET_ORDER_DETAIL_BY_ID_IN_MANAGEMENT),
            API.with("^/management/products/(.*)", ApiList.API_GET_PRODUCT_DETAIL),
            API.with("^/management/accounts/(.*)", ApiList.DELETE_ACCOUNT),
            API.with("^/management/products/oils/(.*)", ApiList.API_UPDATE_PRODUCT_BY_ID),
            API.with("^/permissions/roles/(.*)", ApiList.API_DELETE_ROLE),
            API.with("^/permissions/modules/(.*)", ApiList.API_GET_MODULES_BY_ID),
            API.with("^/management/contracts/(.*)", ApiList.API_GET_CONTRACT),
            API.with("^/management/contracts/rejections/(.*)", ApiList.API_REJECT_CONTRACT),
            API.with("^/management/contracts/acceptances/(.*)", ApiList.API_ACCEPT_CONTRACT),
            API.with("^/management/payment-order/(.*)", ApiList.API_GET_PAYMENT),
            API.with("^/management/products/filters/(.*)", ApiList.API_GET_PRODUCT_NOT_FUEL),
            API.with("^/management/employees/(.*)", ApiList.API_CREATE_EMPLOYEE),
            API.with("^/management/products/except-oils/(.*)", ApiList.API_UPDATE_PRODUCT_EXCEPT_OIL),
            API.with("^/management/import-request/(.*)", ApiList.API_GET_IMPORT_REQUEST),
            API.with("^/management/promotions/(.*)", ApiList.API_GET_BY_ID_PROMOTION),
            API.with("^/management/shifts/(.*)", ApiList.API_UPDATE_SHIFT),
            API.with("^/management/calendars/(.*)", ApiList.API_UPDATE_CALENDAR),
            API.with("^/management/swap-shifts/status/(.*)", ApiList.API_CHANGE_STATUS_SHIFT),
//            API.with("^/management/calendars/(.*)", ApiList.API_UPDATE_CALENDAR),
            API.with("^/management/swap-shifts/(.*)", ApiList.API_GET_DETAIL_SWAP_SHIFT),
            API.with("^/notifications/status-sees/(.*)", ApiList.API_UPDATE_STATUS_SEE),
            API.with("^/management/product-revenue/(.*)", ApiList.API_GET_PRODUCT_REVENUE_BY_ID),
            API.with("^/management/import-request/handles/(.*)", ApiList.API_CONFIRM_OR_IMPORT_REQUEST_ORDER),
            API.with("^/management/warehouse-orders/details/(.*)", ApiList.API_GET_DETAIL_WAREHOUSE),
            API.with("^/management/warehouse-orders/refuses/(.*)", ApiList.API_REFUSES_WAREHOUSE_ORDER),
            API.with("^/management/warehouse-orders/request-adjustments/(.*)", ApiList.API_REQUIRE_ADJUSTMENT_WAREHOUSE_ORDER),
            API.with("^/management/transit-cars/(.*)", ApiList.API_GET_TRANSIT_CAR),
            API.with("^/management/warehouse-orders/approves/(.*)", ApiList.API_GET_WAREHOUSE_ORDER_APPROVES),
            API.with("^/management/warehouse-orders/(.*)", ApiList.API_SENT_BROWSE_WAREHOUSE_ORDER),
            API.with("^/management/warehouse-import/(.*)", ApiList.API_GET_WAREHOUSE_IMPORT),
            API.with("^/management/warehouse-import/word/(.*)", ApiList.API_EXPORT_WARE_HOSE_IMPORT),
            API.with("^/management/warehouse-export/word(.*)", ApiList.API_GET_WAREHOUSE_IMPORT),
            API.with("^/management/warehouse-export/(.*)", ApiList.API_EXPORT_WARE_HOSE_EXPORT),
            API.with("^/management/shallows/export/word/(.*)", ApiList.API_EXPORT_WARE_HOSE_SHALLOW),
            API.with("^/management/banners/(.*)", ApiList.API_UPDATE_BANNER),
            API.with("^/management/swap-shifts/calendar/(.*)", ApiList.API_UPDATE_CHANGE_SHIFT),
            API.with("^/management/news/(.*)", ApiList.API_UPDATE_OR_DELETE),
            API.with("^/management/swap-shifts/roll-back/(.*)", ApiList.API_ROLL_BACK_SWAP_SHIFT),
            API.with("^/management/import-request/import-product/(.*)", ApiList.API_UPDATE_CHANGE_IMPORT_REQUEST),
            API.with("^/management/accounts/passwords/reset(.*)", ApiList.API_RESET_PASSWORD),
            API.with("^/management/import-request/confirm-swap/(.*)", ApiList.API_CONFIRM_CHANGE_IMPORT_REQUEST)

    );

    /**
     * Distribute forward API to Service
     *
     * @param requestUrl requestUrl
     * @return String
     */
    public String distribute(String requestUrl) {

        String urlConvert = convertUrlSpecial(requestUrl);

        requestUrl = Strings.isEmpty(urlConvert) ? requestUrl : urlConvert;

        String baseUri = apiForBaseUriMap.get(requestUrl);

        if (StringUtils.isEmpty(baseUri))
            throw new BusinessException(ErrorCode.UNSUPPORTED_RESOURCE, null);

        return baseUri;
    }

    /**
     * Convert Url special to Url easy to understand
     * <p>
     * ex: /management/accounts/{id}
     *
     * @param requestUrl requestUrl
     * @return String
     */
    private String convertUrlSpecial(String requestUrl) {
        for (API api : apiSpecial)
            if (api.isMatchPath(requestUrl))
                return api.getBaseUri();

        return null;
    }

    /**
     * Add API into Map
     */
    @PostConstruct
    public void startApiDistribute() {
        // Base Core Driver
        apiForBaseUriMap.put(ApiList.API_GET_ACCOUNT_INFO_IN_DRIVER, urlDriver);
        apiForBaseUriMap.put(ApiList.API_LOGIN_IN_DRIVER, urlDriver);
        apiForBaseUriMap.put(ApiList.API_REGISTER_ACCOUNT_IN_DRIVE, urlDriver);

        // Base Enterprise
        apiForBaseUriMap.put("/accounts1", urlEnterprise);
        apiForBaseUriMap.put("/accounts2", urlEnterprise);
        apiForBaseUriMap.put("/accounts3", urlEnterprise);

        // base Pay
        apiForBaseUriMap.put("/accounts4", urlPay);

        // Base Admin Management
        apiForBaseUriMap.put(ApiList.API_GET_ACCOUNT_INFO_IN_MANAGEMENT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ACCOUNT_INFORMATION_IN_MANAGEMENT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_LOGIN_IN_MANAGEMENT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_REGISTER_ACCOUNT_IN_MANAGEMENT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_CHANG_PASSWORD_AFTER_FIRST_LOGIN_IN_MANAGEMENT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_FIND_ALL_ACCOUNT_IN_MANAGEMENT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.DELETE_ACCOUNT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_ACCOUNT_DETAIL, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_EMPLOYEE, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_STATION_EMPLOYEE, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_EMPLOYEE, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_QR_CODE_BY_HOSE, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_QR_CODE_BY_PRODUCT, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PROFILE, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_AVATAR_PROFILE, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_STATION_ACTIVE, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_EMPLOYEE_SHIPPING_TEAM, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_AUTHENTICATION_OTP, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_EVALUATION, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_GET_DETAIL_EVALUATION, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_EXPORT_EXCEL_EVALUATION, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_EXPORT_EXCEL_EVALUATION_DETAILS, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_CONNECT_OR_REFUSE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_EVALUATION, urlAdminManagement);
        apiForBaseUriMap.put(ApiList.API_RESET_PASSWORD, urlAdminManagement);

        // Base Public Management
        apiForBaseUriMap.put(ApiList.API_ORDER_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_QR_INFO_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_GAS_FIELD_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_PUMP_POLE_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_DELETE_GAS_STATION_BY_ID_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_DELETE_GAS_FIELD_BY_ID_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_DELETE_GAS_PUMP_POLE_BY_ID_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PUMP_HOSE_BY_ID_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_PRODUCT_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_ADD_A_GAS_STATION, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_DELETE_CATEGORY_BY_ID_IN_MANAGEMENT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ORDER_INFO, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_ROLE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ORDER_ACTUALITY, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ORDER_DETAIL_BY_ID_IN_MANAGEMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ERROR_CODE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PROPERTIES, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PROPERTIES_BY_ID, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_DRIVER_PROFILE_IN_DRIVE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_DEVICE_TOKEN, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_REQUEST_PAYMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_VEHICLE, urlPublicManagement);
//        apiForBaseUriMap.put(ApiList.API_UPLOAD_FILE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_CUSTOMER, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_RANK_STOCK, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_DRIVER_DETAIL, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_RANK, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ACCOUNT_CHILD, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_DISCOUNT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_DOWNLOAD_FILE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PROPERTIES_BY_DEPARTMENT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PAYMENT_METHOD, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_FILTER_ORDER, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_FILTER_ORDER_EXPORT_EXCEL, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_EMPLOYEE_BY_ID, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ORDER_HISTORY, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ORDER_BY_SHIFT_ID, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_STATION_LOCATION, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_PUMP_HOSE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_HISTORY_ACCUMULATE_POINT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_HISTORY_ACCUMULATE_POINT_EXCELS, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_GAS_FIELD, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_SCALE_BY_GAS_FIELD_ID, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_SWAP_POINT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_STATION_CORPORATION, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_SWAP_POINT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CHANGE_PASSWORD, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_BANNER, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_BANNER, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_NEWS, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_OR_DELETE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_RANK_HIGHER, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_TOGGLE_OTP, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_ROLL_BACK_SWAP_SHIFT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_RANK_ACCOUNT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_NEWS_SHOWS, urlPublicManagement);


        // Base permission
        apiForBaseUriMap.put(ApiList.API_GET_GROUPS, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_VALIDATE_GROUPS, urlPermissionManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_ROLES, urlPermissionManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_MODULES, urlPermissionManagement);
        apiForBaseUriMap.put(ApiList.API_DELETE_ROLE, urlPermissionManagement);
        apiForBaseUriMap.put(ApiList.API_GET_MODULES_BY_ID, urlPermissionManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_GROUPS, urlPermissionManagement);

        // Base Wave House Management
        apiForBaseUriMap.put(ApiList.API_GET_PRODUCT_DETAIL, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PRODUCT_BY_CATEGORY, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_DISTRICT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PROVINCE, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_WARD, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_PRODUCT, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_PRODUCT_BY_ID, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_CATEGORY, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_PRODUCT_OILS, urlPublicManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_CATEGORY_ACTIVE, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_AREA_PRODUCT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PRODUCT_NOT_FUEL, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_PRODUCT_EXCEPT_OIL, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_PRODUCT_EXCEPT_OIL, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_LIST_PROMOTION, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_BY_ID_PROMOTION, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_WAREHOUSE_ORDER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_IMPORT_REQUEST, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_FILTER_IMPORT_REQUEST, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_IMPORT_REQUEST, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CONFIRM_OR_IMPORT_REQUEST_ORDER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_PRODUCT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_DETAIL_WAREHOUSE, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_TRACKING_PRICE_PRODUCT_OIL, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_REFUSES_WAREHOUSE_ORDER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_REQUIRE_ADJUSTMENT_WAREHOUSE_ORDER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_SUPPLIER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_SUPPLIER_FORM_ORDER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_TRANSIT_CARS, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_TRANSIT_CAR, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_GAS_FIELD_BY_STATION, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_WAREHOUSE_ORDER_APPROVES, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_SENT_BROWSE_WAREHOUSE_ORDER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_WAREHOUSE_IMPORT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_FILTER_WAREHOUSE_IMPORT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_FILTER_WAREHOUSE_EXPORT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_WAREHOUSE_EXPORT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_COMPLETE_WAREHOUSE_EXPORT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_SUPPLIER_BY_FORM_ORDER, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_MEASURE, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_SHALLOWS, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_SHALLOWS, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_MEASURES, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_EXPORT_WARE_HOSE_EXPORT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_EXPORT_WARE_HOSE_IMPORT, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_EXPORT_WARE_HOSE_MEASURE, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_EXPORT_WARE_HOSE_SHALLOW, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_INFO_MEASURE, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_INFO_SHALLOWS, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_STATION_BY_EMPLOYEE_ID_AND_STATUS, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_STATION_BY_STATUS, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_GAS_FIELD_BY_STATION_ID, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_GET_NEWS_DETAIL, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_UPDATE_CHANGE_IMPORT_REQUEST, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CONFIRM_CHANGE_IMPORT_REQUEST, urlWareHouseManagement);
        apiForBaseUriMap.put(ApiList.API_CREATE_WAREHOUSE_EXPORT, urlWareHouseManagement);

        // contract debt
        apiForBaseUriMap.put(ApiList.API_GET_ALL_CONTRACT, urlContractDebt);
        apiForBaseUriMap.put(ApiList.API_GET_CONTRACT_BY_CUSTOMER, urlContractDebt);
        apiForBaseUriMap.put(ApiList.API_GET_CONTRACT, urlContractDebt);
        apiForBaseUriMap.put(ApiList.API_REJECT_CONTRACT, urlContractDebt);
        apiForBaseUriMap.put(ApiList.API_ACCEPT_CONTRACT, urlContractDebt);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_CONTRACT_ENTERPRISE, urlContractDebt);
        apiForBaseUriMap.put(ApiList.API_CREATE_CONTRACT_PLAN, urlContractDebt);

        // payment
        apiForBaseUriMap.put(ApiList.API_GET_PAYMENT, urlPublicManagement);

        //shift
        apiForBaseUriMap.put(ApiList.API_GET_ALL_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_FILTER_CALENDAR, urlShift);
        apiForBaseUriMap.put(ApiList.API_UPDATE_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_UPDATE_CALENDAR, urlShift);
        apiForBaseUriMap.put(ApiList.API_CREATE_CALENDAR, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_SHIFT_OFF, urlShift);
        apiForBaseUriMap.put(ApiList.API_CREATE_SWAP_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_CREATE_CHANGE_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_UPDATE_CHANGE_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_OTHER_PRODUCT_REVENUE, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_ALL_PROMOTIONAL_REVENUE, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_CONFIRM_LOCK_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_CHANGE_STATUS_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_DETAIL_SWAP_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_CONFIRM_LOCK_SHIFT, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_CALENDAR_INFOS, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_CALENDAR_BY_MONTH, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_PRODUCT_REVENUE, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_PRODUCT_REVENUE_BY_ID, urlShift);
        apiForBaseUriMap.put(ApiList.API_EXPORT_EXCEL_REPORT_TOTAL_REVENUE, urlShift);
        apiForBaseUriMap.put(ApiList.API_GET_SHIFT_WITH_DATE, urlShift);
        apiForBaseUriMap.put(ApiList.API_FILTER_SWAP_SHIFT_WITH_ACCOUNT, urlShift);

        // Notify
        apiForBaseUriMap.put(ApiList.API_GET_ALL_NOTIFICATION_EMPLOYEE, urlNotify);
        apiForBaseUriMap.put(ApiList.API_GET_STATUS_SEEN_OF_EMPLOYEE, urlNotify);
        apiForBaseUriMap.put(ApiList.API_UPDATE_STATUS_SEE, urlNotify);


    }

    /**
     * Get Api change password after First login
     *
     * @return String
     */
    public String getAPIChangePasswordFirstLogin() {
        return urlAdminManagement + ApiList.API_CHANG_PASSWORD_AFTER_FIRST_LOGIN_IN_MANAGEMENT;
    }

}
