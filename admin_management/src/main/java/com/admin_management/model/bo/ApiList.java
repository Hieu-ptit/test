package com.admin_management.model.bo;

public interface ApiList {

    // permission
    String API_CHECK_PERMISSION = "permissions/roles/validators";

    String API_SAVE_ROLES_ACCOUNT = "permissions/roles-account";

    String API_GET_ROLES_ACCOUNT_ID = "permissions/roles/infos?account-id=%s";

    // Specific Management

    // Driver
    String API_DELETE_DRIVER_ACCOUNT = "drivers/accounts/driver/%s";

    String API_CHECK_DRIVER_ACCOUNT = "drivers/accounts/driver-exits/%s";

    //Public management
    String API_GET_PROPERTIES = "/management/properties/department-type?code=%s&type=%s";
    String API_CREATE_EMPLOYEE_STATION = "/management/gas-stations/station-employee";
    String API_GET_EMPLOYEE_STATION = "/management/gas-stations/station-employee/%s";
    String API_GET_FILE = "/management/files/%s";
    String API_GET_STATION = "/management/gas-stations/%s";
    String API_GET_DISTRICT_BY_ID_PROVINCE = "/management/districts?province-id=%s";
    String API_GET_WARD_BY_ID_DISTRICT = "/management/wards?district-id=%s";
    String API_GET_WARD_BY_ID = "/management/wards/%s";
    String API_GET_STATION_BY_ID = "/management/gas-stations/%s";
    String API_GET_STATION_BY_EMPLOYEE_ID = "/management/gas-stations/location-word?employee-id=%s";
    String API_EMPLOYEE_BY_STATION_NAME = "/management/gas-stations/station-name?name-station=%s";
    String API_EMPLOYEE_BY_ID = "/management/gas-stations/employee-station?employee-id=%d";
    String API_DELETE_EMPLOYEE_STATION = "/management/gas-stations/employee-station/%s";
    String GET_STATION_NAME = "/management/gas-stations/names?employee-id=%d";
    String API_GET_STATION_ACTIVE_BY_EMPLOYEE_ID = "/management/gas-stations/station-status?employee-id=%d";
    String API_GET_BY_DRIVER_AND_CODE_AND_EMPLOYEE = "/management/orders/evaluation?driver-id=%s&order-code=%s&employee-id=%d";
    String API_GET_QR_CODE_BY_HOSE = "/management/qrs/hoses/listed";

    //Ware house Management
    String API_GET_QR_CODE_BY_OTHER_PRODUCT = "/management/products/filters/others";

    String API_CREATE_MEDIA_INFO = "/management/medias/excels";

    //shift management
    String API_DELETE_CALENDAR = "/management/calendars/employee?employee-id=%d";
}
