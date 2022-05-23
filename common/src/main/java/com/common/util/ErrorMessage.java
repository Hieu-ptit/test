package com.common.util;

public interface ErrorMessage {

    String ACCOUNT_NOT_FOUND_OR_ACTIVE = "Account with username %s not found or active !";

    String ACCOUNT_NOT_VALID = "This account with username %s has changed its password on the last login !";

    String NOT_AUTHENTICATION = "This user not authentication ";

    String UNAUTHORIZED = "Permission denied !";

    String CALENDARS_NOT_FOUND = "Calendar not found";

    String CAN_NOT_DELETE_SESSION = "cannot delete driver session with id = %s";

    String ID_INVALID_WITH_STATUS = "Id %s does not valid with status %s  !";

    String PASSWORD_WRONG = "Password wrong !";

    String ORDER_ARE_WAIT_FOR_PAY = "Order are wait for pay!";

    String POINT_SWAP_INVALID = "Point swap invalid!";

    String PUMP_HOSE_NOT_FOUND = "Pump hose with id %s not found!";

    String PUMP_POLE_NOT_FOUND = "Pump pole with id %s not found!";

    String GAS_STATION_NOT_FOUND = "Gas station with id %s not found!";

    String GAS_FIELD_NOT_FOUND = "Gas field with id %s not found!";

    String PRODUCT_NOT_FOUND = "Product with id %s not found!";

    String NOT_ENOUGH_CONDITION_FOR_CHANGING_PASSWORD = "You are not eligible to change your password !";

    String QR_CODE_NOT_FOUND = "QR CODE with id %s not found!";

    String PUMP_HOSE_CODE_EXIT = "Pump hose code %s already exist";

    String PUMP_HOSE_NAME_EXIT = "Pump hose name %s already exist";

    String PUMP_POLE_CODE_EXIT = "Pump pole code %s already exist";

    String PUMP_POLE_NAME_EXIT = "Pump pole name %s already exist";

    String GAS_STATION_INACTIVE = "Gas station  %s inactive ";

    String GAS_FIELD_CODE_EXIT = "Gas field code %s already exist";

    String GAS_FIELD_NAME_EXIT = "Gas field name %s already exist";

    String PAYMENT_METHOD_NOT_FOUND = "Payment method with id %s not found!";

    String ACCOUNT_OF_DRIVER_NOT_FOUND_OR_ACTIVE = "Account of driver with id %s not found or active !";

    String GAS_STATION_REQUEST_NULL = "There is no request object passed in.";

    String GAS_STATION_NAME_EXISTED = "Gas station with name %s is already existed";

    String GAS_STATION_CODE_EXISTED = "Gas station with code %s is already existed";

    String PROPERTIES_IS_NULL = "Properties with id %s is null";

    String FILE_NOT_EXIST = "File with id %s not exist";

    String PRODUCT_INACTIVE = "Product  %s inactive ";

    String CATEGORY_NOT_FOUND = "Category id %s not found!";

    String PRODUCT_TYPE_NOT_SUPPORT = "Product type not support ";

    String PRODUCT_EXCHANGE_RATE_NOT_FOUND = "Product exchange rate not found";

    String CONFLICT_VALUE_PRICE_N_VOLUMED = "Your limit is not enough to create an order.Please check again.";

    String LIMIT_MONEY_NOT_FOUND = "Can not get value of limit cash money with id driverId %s";

    String LIMIT_OIL_NOT_FOUND = "Can not get value of limit cash oil with id driverId %s";

    String INVALID_MONEY_VALUE = "invalid money value";

    String INVALID_OIL_VALUE = "invalid oil value";

    String CATEGORY_CAN_NOT_DELETE = "Category can not delete";

    String ORDER_IS_CANCEL = "Order has been cancelled";

    String ORDER_NOT_FOUND = "Order with id %s not found!";

    String ORDER_ARE_NOT_FOUND_OR_PROCESSING = "Order is not found processing!";

    String ORDER_DONE_FINISH_PROCESS = "Order do not found or do not finish processing !";

    String DATA_IS_NULL = "Data is null";

    String CASH_LIMIT_NOT_FOUND = "Cash limit of driverId %s not found";

    String CASH_LIMIT_DETAIL_NOT_FOUND = "Cash limit detail of driverId %s not found";

    String PROVINCE_NOT_FOUND = "Province with id %s not found";

    String DISTRICT_NOT_FOUND = "District with id %s not found";

    String GROUP_PERMISSION_INVALID = "Groups permission in module %s is invalid";

    String ACCOUNT_ROLE_IS_EXISTED = "Account role is existed";

    String USERNAME_IS_EXISTED = "Username is existed";

    String CODE_IS_EXISTED = "Code is existed";

    String FILE_TOO_LARGE = "File is too large !";

    String ONLY_UPLOAD_10_FILES = "Only 10 files can be inserted once";

    String CONTENT_TYPE_NULL = "Content type null";

    String LIMIT_MONEY_NOT_ENOUGH = "limit cash money not enough";

    String ACCOUNT_NOT_FOUND_OR_DELETE = "Account with id %s not found or status delete";

    String MESSAGE_ERROR = "Invalid field format";

    String REQUIRE = "require";

    String TYPE = "type";

    String INVALID = "Invalid";

    String CAN_NOT_ENCODE_JSON_OBJECT_OF_TYPE = "Can't encode json object of type: ";

    String CAN_NOT_ENCODE_JSON_OBJECT = "Can't encode json object";

    String PHOTO_VOUCHER_IS_NULL = "Photo voucher is not null";

    String ACCOUNT_NOT_FOUND_OR_PHONE_NUMBER_EXITS = "Account not fount or phone number %s exits";

    String EMPLOYEE_NOT_EXIST = "Employee with this account id %s not exist ";

    String RANK_STOCK_NOT_FOUND = "Rank stock with id %s not found!";

    String RANK_STOCK_IS_NULL = "Rank stock with product id %s and rank id %s not found!";

    String RANK_NOT_FOUND = "Rank id %s not found!";

    String ENTERPRISE_NOT_FOUND = "Enterprise with id %s not found !";

    String LIST_RANK_STOCK_DISCOUNT_INVALID = "List rank stock discount with ids %s invalid";

    String LICENSE_PLATE_IS_NOT_FOUND = "License plate not found !";

    String TAKE_A_PHOTO_LICENSE_PLATE = "You must take a photo of the license plate";

    String NON_PROPRIETARY_RESOURCES = "Non proprietary resources";

    String DATE_INVALID = "Date invalid ";

    String FILE_NOT_FOUND = "File with id not found!";

    String PHONE_EXIST = "Phone %s exist!";

    String EMAIL_EXIST = "Email %s exist!";

    String ID_NUMBER_EXIST = "Identity card number %s exist!";

    String ORDER_ARE_BEING_PROCESSED = "Đang có đơn hàng được xử lý.";

    String WARD_NOT_FOUND = "Ward %s not found ";

    String EXIST_EMPLOYEE_IN_STATION = "Station id %s exist employee ";

    String PROFILE_NOT_FOUND = "Profile id %s not found ";

    String BANNER_IS_NOT_FOUND = "Banner %s not found ";

    String NEWS_IS_NOT_FOUND = "News not found with id %d ";
}
