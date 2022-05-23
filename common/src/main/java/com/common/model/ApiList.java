package com.common.model;

public interface ApiList {

    // DRIVER
    String API_GET_ACCOUNT_INFO_IN_DRIVER = "/drivers/accounts/infos";
    String API_LOGIN_IN_DRIVER = "/drivers/accounts/login";
    String API_REGISTER_ACCOUNT_IN_DRIVE = "/drivers/accounts/register";

    // Enterprise

    // ADMIN Management
    String API_GET_ACCOUNT_INFO_IN_MANAGEMENT = "/management/accounts/infos";
    String API_GET_ACCOUNT_INFORMATION_IN_MANAGEMENT = "/management/accounts/information";
    String API_LOGIN_IN_MANAGEMENT = "/management/accounts/login";
    String API_REGISTER_ACCOUNT_IN_MANAGEMENT = "/management/accounts/register";
    String API_CHANG_PASSWORD_AFTER_FIRST_LOGIN_IN_MANAGEMENT = "/management/accounts/passwords/first";
    String API_FIND_ALL_ACCOUNT_IN_MANAGEMENT = "/management/accounts";
    String DELETE_ACCOUNT = "/management/accounts/{id}";
    String API_ACCOUNT_DETAIL = "/management/accounts/details";
    String API_CREATE_EMPLOYEE = "/management/employees";
    String API_GET_ALL_EMPLOYEE = "/management/employees/staff";
    String API_GET_QR_CODE_BY_HOSE = "/management/qrs/hoses";
    String API_GET_QR_CODE_BY_PRODUCT = "/management/qrs/products/others";
    String API_GET_PROFILE = "/management/profiles";
    String API_UPDATE_AVATAR_PROFILE = "/management/profiles/avatar";
    String API_GET_STATION_ACTIVE = "/management/employees/station-active";
    String API_GET_EMPLOYEE_SHIPPING_TEAM = "/management/employees/shipping-team";
    String API_AUTHENTICATION_OTP = "/management/accounts/authentication/otps";
    String API_CREATE_EVALUATION = "/management/evaluations/employee/filters";
    String API_RESET_PASSWORD = "/management/accounts/passwords/reset/{id}";

    // Public management
    String API_GET_QR_INFO_MANAGEMENT = "/management/qrs/infos";
    String API_ORDER_MANAGEMENT = "/management/orders";
    String API_CREATE_PUMP_POLE_IN_MANAGEMENT = "/management/pump-poles";
    String API_CREATE_GAS_FIELD_IN_MANAGEMENT = "/management/gas-fields";
    String API_DELETE_GAS_FIELD_BY_ID_IN_MANAGEMENT = "/management/gas-fields/{id}";
    String API_DELETE_GAS_STATION_BY_ID_IN_MANAGEMENT = "/management/gas-stations/{id}";
    String API_GET_ORDER_DETAIL_BY_ID_IN_MANAGEMENT = "/management/orders/{id}";
    String API_DELETE_GAS_PUMP_POLE_BY_ID_IN_MANAGEMENT = "/management/pump-poles/{id}";
    String API_GET_PUMP_HOSE_BY_ID_IN_MANAGEMENT = "/management/pump-hoses";
    String API_GET_ALL_PRODUCT_IN_MANAGEMENT = "/management/products";
    String API_ADD_A_GAS_STATION = "/management/gas-stations";
    String API_DELETE_CATEGORY_BY_ID_IN_MANAGEMENT = "/management/categories/{id}";
    String API_UPDATE_PUMP_HOSE = "/management/pump-hoses/{id}";
    String API_UPDATE_GAS_FIELD = "/management/gas-fields/{id}";
    String API_UPDATE_PUMP_POLE = "/management/pump-poles/{id}";
    String API_GET_ORDER_INFO = "/management/orders/info";
    String API_CREATE_ROLE = "/management/roles";
    String API_GET_ORDER_ACTUALITY = "/management/orders/actuality-pay/{id}";
    String API_GET_PROVINCE = "/management/provinces";
    String API_GET_DISTRICT = "/management/districts";
    String API_GET_WARD = "/management/wards";
    String API_GET_ERROR_CODE = "/management/error-codes";
    String API_GET_PROPERTIES = "/management/properties";
    String API_GET_PROPERTIES_BY_ID = "/management/properties/contracts-type";
    String API_GET_DRIVER_PROFILE_IN_DRIVE = "/management/drivers/information";
    String API_CREATE_DEVICE_TOKEN = "/management/device-tokens";
    String API_UPLOAD_FILE = "/management/files";
    String API_REQUEST_PAYMENT = "/management/orders/confirmed-pay";
    String API_GET_VEHICLE = "/management/vehicles";
    String API_GET_ALL_CUSTOMER = "/management/customers";
    String API_GET_ALL_RANK_STOCK = "/management/rank-stock";
    String API_GET_DRIVER_DETAIL = "/management/customers/infos";
    String API_UPDATE_ACCOUNT_DRIVER = "/management/customers/{id}";
    String API_GET_RANK = "/management/ranks";
    String API_GET_ACCOUNT_CHILD = "/management/customers/accounts-children";
    String API_UPDATE_DISCOUNT = "/management/rank-stock/discounts";
    String API_UPLOAD_IMAGE_SPEEDOMETER = "/management/files/speedometer";
    String API_UPLOAD_IMAGE_LICENSE_PLATE = "/management/files/license-plates";
    String API_DOWNLOAD_FILE = "/management/files/downloads";
    String API_GET_PROPERTIES_BY_DEPARTMENT = "/management/properties/department";
    String API_GET_STATION_EMPLOYEE = "/management/gas-stations/station-employee";
    String API_GET_PAYMENT_METHOD = "/management/payments/methods/actively";
    String API_FILTER_ORDER = "/management/orders/filters";
    String API_FILTER_ORDER_EXPORT_EXCEL = "/management/orders/filters/excels";
    String API_GET_EMPLOYEE_BY_ID = "/management/gas-stations/employee";
    String API_GET_EMPLOYEE_BY_EMPLOYEE_ID = "/management/employees/details/{id}";
    String API_GET_ORDER_HISTORY = "/management/orders/customers/histories";
    String API_GET_ORDER_BY_SHIFT_ID = "/management/orders/shift-order";
    String API_GET_STATION_LOCATION = "/management/gas-stations/location-station";
    String API_GET_HISTORY_ACCUMULATE_POINT = "/management/payments/methods/histories/accumulate";
    String API_GET_HISTORY_ACCUMULATE_POINT_EXCELS = "/management/payments/methods/histories/accumulate/excels";
    String API_GET_GAS_FIELD = "/management/gas-fields/station-product";
    String API_GET_SCALE_BY_GAS_FIELD_ID = "/management/scales";
    String API_CREATE_SWAP_POINT = "/management/swap-point";
    String API_STATION_CORPORATION = "/management/corporation";
    String API_GET_SWAP_POINT = "/management/swap-point/filter";
    String API_CHANGE_PASSWORD = "/management/accounts/passwords/changers";
    String API_GET_BANNER = "/management/banners";
    String API_UPDATE_BANNER = "/management/banners/{id}";
    String API_GET_ALL_NEWS = "/management/news";
    String API_UPDATE_OR_DELETE = "/management/news/{id}";
    String API_GET_NEWS_DETAIL = "/management/news/details/{id}";
    String API_GET_RANK_HIGHER = "/management/ranks/highers";
    String API_GET_TOGGLE_OTP = "/management/accounts/toggles/otps";
    String API_ROLL_BACK_SWAP_SHIFT = "/management/swap-shifts/roll-back/{id}";
    String API_UPDATE_RANK_ACCOUNT = "/management/customers/ranks";
    String API_GET_ALL_NEWS_SHOWS = "/management/news/shows";
    String API_GET_ALL_EVALUATION = "/management/evaluations/filters";
    String API_EXPORT_EXCEL_EVALUATION = "/management/evaluations/filters/excels";
    String API_EXPORT_EXCEL_EVALUATION_DETAILS = "/management/evaluations/export/excels";
    String API_CONNECT_OR_REFUSE = "/management/orders/confirm-reject-order";
    String API_GET_DETAIL_EVALUATION = "/management/evaluations/detail";

    // permission
    String API_GET_GROUPS = "/management/groups";
    String API_VALIDATE_GROUPS = "/permissions/groups/validation";
    String API_GET_ALL_ROLES = "/permissions/roles";
    String API_GET_ALL_MODULES = "/permissions/modules";
    String API_DELETE_ROLE = "/permissions/roles/{id}";
    String API_GET_MODULES_BY_ID = "/permissions/modules/{id}";
    String API_GET_ALL_GROUPS = "/permissions/groups/log";

    // WaveHouse Management
    String API_GET_PRODUCT_DETAIL = "/management/products/{id}";
    String API_UPDATE_PRODUCT_BY_ID = "/management/products/oils/{id}";
    String API_GET_PRODUCT_BY_CATEGORY = "/management/products/category/{categoryId}";
    String API_CREATE_PRODUCT = "/management/products/oils";
    String API_CREATE_PRODUCT_OILS = "/management/products/products-oils";
    String API_GET_ALL_CATEGORY = "/management/categories";
    String API_GET_ALL_CATEGORY_ACTIVE = "/management/categories/actives";
    String API_DELETE_CATEGORY = "/management/categories/{id}";
    String API_GET_AREA_PRODUCT = "/management/area-products";
    String API_GET_PRODUCT_NOT_FUEL = "/management/products/filters";
    String API_CREATE_PRODUCT_EXCEPT_OIL = "/management/products/except-oils";
    String API_UPDATE_PRODUCT_EXCEPT_OIL = "/management/products/except-oils/{id}";
    String API_GET_LIST_PROMOTION = "/management/promotions";
    String API_GET_BY_ID_PROMOTION = "/management/promotions/{id}";
    String API_GET_WAREHOUSE_ORDER = "/management/warehouse-orders/filters";
    String API_CREATE_IMPORT_REQUEST = "/management/import-request";
    String API_FILTER_IMPORT_REQUEST = "/management/import-request/filters";
    String API_GET_IMPORT_REQUEST = "/management/import-request/{id}";
    String API_CONFIRM_OR_IMPORT_REQUEST_ORDER = "/management/import-request/handles/{id}";
    String API_GET_PRODUCT = "/management/products/other/{id}";
    String API_GET_TRACKING_PRICE_PRODUCT_OIL = "/management/tracking-price";
    String API_GET_DETAIL_WAREHOUSE = "/management/warehouse-orders/details/{warehouse-order-id}";
    String API_REQUIRE_ADJUSTMENT_WAREHOUSE_ORDER = "/management/warehouse-orders/request-adjustments/{warehouse-order-id}";
    String API_REFUSES_WAREHOUSE_ORDER = "/management/warehouse-orders/refuses/{id}";
    String API_GET_ALL_SUPPLIER = "/management/suppliers";
    String API_GET_SUPPLIER_FORM_ORDER = "/management/suppliers/exports";
    String API_GET_ALL_TRANSIT_CARS = "/management/transit-cars";
    String API_GET_TRANSIT_CAR = "/management/transit-cars/{id}";
    String API_GET_GAS_FIELD_BY_STATION = "/management/suppliers/stations";
    String API_GET_WAREHOUSE_ORDER_APPROVES = "/management/warehouse-orders/approves/{id}";
    String API_SENT_BROWSE_WAREHOUSE_ORDER = "/management/warehouse-orders/{id}";
    String API_GET_WAREHOUSE_EXPORT = "/management/warehouse-export/{id}";
    String API_COMPLETE_WAREHOUSE_EXPORT = "/management/warehouse-export/complete/{id}";
    String API_GET_WAREHOUSE_IMPORT = "/management/warehouse-import/{id}";
    String API_FILTER_WAREHOUSE_IMPORT = "/management/warehouse-import/filters";
    String API_FILTER_WAREHOUSE_EXPORT = "/management/warehouse-export/filters";
    String API_GET_SUPPLIER_BY_FORM_ORDER = "/management/suppliers/stations/import-export";
    String API_GET_MEASURE = "/management/measures/filters";
    String API_GET_SHALLOWS = "/management/shallows/filters";
    String API_CREATE_SHALLOWS = "/management/shallows";
    String API_GET_INFO_SHALLOWS = "/management/shallows/infos";
    String API_CREATE_MEASURES = "/management/measures";
    String API_EXPORT_WARE_HOSE_IMPORT = "/management/warehouse-import/word/{id}";
    String API_EXPORT_WARE_HOSE_EXPORT = "/management/warehouse-export/word/{id}";
    String API_EXPORT_WARE_HOSE_MEASURE = "/management/measures/export/word";
    String API_EXPORT_WARE_HOSE_SHALLOW = "/management/shallows/export/word/{id}";
    String API_GET_INFO_MEASURE = "/management/measures/infos";
    String API_GET_STATION_BY_EMPLOYEE_ID_AND_STATUS = "/management/employee/status-corporation";
    String API_GET_STATION_BY_STATUS = "/management/status-corporation";
    String API_GET_GAS_FIELD_BY_STATION_ID = "/management/gas-fields/station";
    String API_UPDATE_CHANGE_IMPORT_REQUEST = "/management/import-request/import-product/{id}";
    String API_CONFIRM_CHANGE_IMPORT_REQUEST = "/management/import-request/confirm-swap/{id}";
    String API_CREATE_WAREHOUSE_EXPORT = "/management/warehouse-export";

    // contract debt

    String API_GET_ALL_CONTRACT = "/management/contracts";
    String API_CREATE_CONTRACT_PLAN = "/management/contracts/plan";
    String API_GET_CONTRACT_BY_CUSTOMER = "/management/contracts/customers";
    String API_GET_CONTRACT = "/management/contracts/{id}";
    String API_REJECT_CONTRACT = "/management/contracts/rejections/{id}";
    String API_ACCEPT_CONTRACT = "/management/contracts/acceptances/{id}";
    String API_GET_ALL_CONTRACT_ENTERPRISE = "/management/contracts/enterprise";

    //
    String API_GET_PAYMENT = "/management/payment-order/{id}";

    //
    String API_INTEGRATE_AI = "/detect_lp?date=%s&name=%s";

    //Shift
    String API_GET_ALL_SHIFT = "/management/shifts";
    String API_FILTER_CALENDAR = "/management/lock-shifts/filter";
    String API_UPDATE_SHIFT = "/management/shifts/{id}";
    String API_CREATE_CALENDAR = "/management/calendars";
    String API_UPDATE_CALENDAR = "/management/calendars/{id}";
    String API_GET_SHIFT_OFF = "/management/shifts-off-time";
    String API_CREATE_SWAP_SHIFT = "/management/swap-shifts";
    String API_CREATE_CHANGE_SHIFT = "/management/swap-shifts/calendar";
    String API_UPDATE_CHANGE_SHIFT = "/management/swap-shifts/calendar/{id}";
    String API_GET_ALL_OTHER_PRODUCT_REVENUE = "/management/other-product-revenue";
    String API_GET_ALL_PROMOTIONAL_REVENUE = "/management/promotional-revenue";
    String API_GET_CONFIRM_LOCK_SHIFT = "/management/lock-shifts";
    String API_GET_DETAIL_SWAP_SHIFT = "/management/swap-shifts/{id}";
    String API_CONFIRM_LOCK_SHIFT = "/management/lock-shifts/order-shift";
    String API_CHANGE_STATUS_SHIFT = "/managing/swap-shifts/status/{swap-shift-id}";
    String API_GET_CALENDAR_INFOS = "/management/calendars/employees/infos";
    String API_GET_CALENDAR_BY_MONTH = "/management/calendars/employees";
    String API_GET_PRODUCT_REVENUE = "/management/product-revenue";
    String API_GET_PRODUCT_REVENUE_BY_ID = "/management/product-revenue/{id}";
    String API_EXPORT_EXCEL_REPORT_TOTAL_REVENUE = "/management/excel-exporters/total-revenues";
    String API_GET_SHIFT_WITH_DATE = "/management/shifts/days";
    String API_FILTER_SWAP_SHIFT_WITH_ACCOUNT = "/management/swap-shifts/employees";

    // permission
    String API_GET_ROLES = "/permissions/roles/infos?account-id=%s";
    String API_GET_ACTIONS = "/permissions/roles/actions?account-id=%s";
    String API_AUTHORIZATION = "/permissions/roles/authorizations";

    // notify

    String API_GET_ALL_NOTIFICATION_EMPLOYEE = "/notifications/employees";
    String API_GET_STATUS_SEEN_OF_EMPLOYEE = "/notifications/employees/compilations";
    String API_UPDATE_STATUS_SEE = "/notifications/status-sees/{id}";
}
