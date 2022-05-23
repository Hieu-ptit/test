package com.common.util;

import com.common.exception.BusinessErrorCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ErrorCode {
    private static final Logger log = LogManager.getLogger(ErrorCode.class);
    public static final BusinessErrorCode INTERNAL_SERVER_ERROR =
            new BusinessErrorCode(5000, "Internal server error", 503);

    public static final BusinessErrorCode INTERNAL_STORAGE_ERROR =
            new BusinessErrorCode(5001, "Internal storage error", 503);

    public static final BusinessErrorCode INTERNAL_BUFFER_ERROR =
            new BusinessErrorCode(5002, "Buffer connect fail", 503);

    public static final BusinessErrorCode COULD_NOT_GENERATE_QR =
            new BusinessErrorCode(5003, "Could not Generate QR code", 503);

    public static final BusinessErrorCode NOT_HAVE_OPERATOR_FIT =
            new BusinessErrorCode(5005, "There is not operator fit", 503);

    public static final BusinessErrorCode AUTHENTICATION_FAILED =
            new BusinessErrorCode(4871, "Authentication failed", 400);

    public static final BusinessErrorCode COULD_NOT_GENERATE_CODE =
            new BusinessErrorCode(5004, "Could not Generate code for object", 503);

    public static final BusinessErrorCode ACCOUNT_NOT_FOUND =
            new BusinessErrorCode(4001, "Account is not found or not active", 400);

    public static final BusinessErrorCode ACCOUNT_BALANCE_NOT_FOUND =
            new BusinessErrorCode(4003, "AccountBalance is not found", 400);

    public static final BusinessErrorCode PHONE_NOT_VERIFY =
            new BusinessErrorCode(4004, "Phone number haven't been verified", 400);

    public static final BusinessErrorCode INSERT_INTO_MEDIA_FAIL =
            new BusinessErrorCode(4777, "Insert into media fail", 400);

    public static final BusinessErrorCode EVALUATION_IS_EXIST =
            new BusinessErrorCode(4994, "Evaluation is exist!", 400);

    public static final BusinessErrorCode WRONG_PASSWORD =
            new BusinessErrorCode(4002, "Wrong password", 400);

    public static final BusinessErrorCode PASSWORD_INVALID =
            new BusinessErrorCode(4053, "Password invalid", 400);

    public static final BusinessErrorCode NOT_AUTHENTICATION =
            new BusinessErrorCode(4008, "You need to login to to access this resource", 401);

    public static final BusinessErrorCode PHONE_NUMBER_EXIST =
            new BusinessErrorCode(4009, "Phone number already exists", 400);

    public static final BusinessErrorCode UNSUPPORTED_RESOURCE =
            new BusinessErrorCode(4010, "Unsupported resource", 400);

    public static final BusinessErrorCode INVALID_FIELD_FORMAT =
            new BusinessErrorCode(4013, "Invalid field format", 400);
    public static final BusinessErrorCode ACCOUNT_LOGGED_OUT =
            new BusinessErrorCode(4014, "You have logged out", 401);
    public static final BusinessErrorCode SESSION_ENDED =
            new BusinessErrorCode(4015, "Your session has been ended", 401);
    public static final BusinessErrorCode UNAUTHORIZED =
            new BusinessErrorCode(4016, "You need to login to to access this resource", 401);
    public static final BusinessErrorCode FORBIDDEN =
            new BusinessErrorCode(4017, "You don't have permission to to access this resource", 403);
    public static final BusinessErrorCode ACCOUNT_FOLLOWED =
            new BusinessErrorCode(4023, "Already follow this account", 400);
    public static final BusinessErrorCode MISSING_PARAMETER =
            new BusinessErrorCode(4024, "Missing parameter", 400);
    public static final BusinessErrorCode OTP_SERVER_DENIES_REQUEST =
            new BusinessErrorCode(4025, "OTP server denied request", 400);
    public static final BusinessErrorCode FORMAT_DATE_INVALID =
            new BusinessErrorCode(4026, "Date format error", 400);
    public static final BusinessErrorCode FILE_NOT_FOUND =
            new BusinessErrorCode(4210, "File not found", 400);
    public static final BusinessErrorCode INVALID_FIELD_NAME =
            new BusinessErrorCode(4027, "Field name is invalid", 400);
    public static final BusinessErrorCode BOOLEAN_FIELD_NAME =
            new BusinessErrorCode(4028, "Boolean name is invalid", 400);
    public static final BusinessErrorCode NUMBER_FORMAT_ERROR =
            new BusinessErrorCode(4029, "Number format error", 400);
    public static final BusinessErrorCode UNSUPPORTED_ACTION_REF =
            new BusinessErrorCode(4030, "Unsupported action ref", 400);
    public static final BusinessErrorCode ENUM_FIELD_VALUE_INVALID =
            new BusinessErrorCode(4031, "Enum value is invalid", 400);
    public static final BusinessErrorCode CALENDARS_NOT_FOUND =
            new BusinessErrorCode(4960, "Calendar not found", 400);
    public static final BusinessErrorCode PHONE_NUMBER_NOT_FOUND =
            new BusinessErrorCode(4032, "Phone number is not found", 400);
    public static final BusinessErrorCode BOOLEAN_FORMAT_ERROR =
            new BusinessErrorCode(4033, "Invalid value of boolean type", 400);
    public static final BusinessErrorCode INVALID_FILTER_OPERATOR =
            new BusinessErrorCode(4034, "Invalid filter operator", 400);
    public static final BusinessErrorCode INVALID_REQUEST =
            new BusinessErrorCode(4036, "Invalid request", 400);

    public static final BusinessErrorCode GAS_STATION_NOT_FOUND =
            new BusinessErrorCode(4105, "Gas station not found", 400);

    public static final BusinessErrorCode PRODUCT_NOT_FOUND =
            new BusinessErrorCode(4115, "Product not found", 400);

    public static final BusinessErrorCode NOT_ENOUGH_CONDITION_FOR_CHANGING_PASSWORD =
            new BusinessErrorCode(4220, ErrorMessage.NOT_ENOUGH_CONDITION_FOR_CHANGING_PASSWORD, 400);

    public static final BusinessErrorCode QR_CODE_NOT_FOUND =
            new BusinessErrorCode(4101, "Qr code not found", 400);

    public static final BusinessErrorCode PUMP_HOSE_CODE_EXITS =
            new BusinessErrorCode(4102, "Pump hose code already exist", 400);

    public static final BusinessErrorCode PUMP_HOSE_NAME_EXITS =
            new BusinessErrorCode(4103, "Pump hose name already exist", 400);

    public static final BusinessErrorCode PUMP_HOSE_NOT_FOUND =
            new BusinessErrorCode(4104, "Pump hose not found", 400);

    public static final BusinessErrorCode PUMP_POLE_NOT_FOUND =
            new BusinessErrorCode(4106, "Pump pole not found", 400);

    public static final BusinessErrorCode GAS_FIELD_NOT_FOUND =
            new BusinessErrorCode(4107, "Gas field not found", 400);

    public static final BusinessErrorCode POINT_SWAP_INVALID =
            new BusinessErrorCode(4278, "Point swap invalid", 400);

    public static final BusinessErrorCode PUMP_POLE_CODE_EXITS =
            new BusinessErrorCode(4108, "Pump pole code already exist", 400);

    public static final BusinessErrorCode PUMP_POLE_NAME_EXITS =
            new BusinessErrorCode(4109, "Pump pole name already exist", 400);

    public static final BusinessErrorCode GAS_STATION_INACTIVE =
            new BusinessErrorCode(4243, "Gas station  inactive", 400);

    public static final BusinessErrorCode GAS_FIELD_CODE_EXITS =
            new BusinessErrorCode(4111, "Pump pole code already exist", 400);

    public static final BusinessErrorCode GAS_FIELD_NAME_EXITS =
            new BusinessErrorCode(4112, "Pump pole name already exist", 400);

    public static final BusinessErrorCode PAYMENT_METHOD_NOT_FOUND =
            new BusinessErrorCode(4113, "Payment method not found", 400);
    public static final BusinessErrorCode ACCOUNT_OF_DRIVER_NOT_FOUND =
            new BusinessErrorCode(4114, "Account of driver is not found or not active", 400);

    public static final BusinessErrorCode GAS_STATION_NAME_EXISTED =
            new BusinessErrorCode(4148, "Gas station with name %s is already existed", 400);

    public static final BusinessErrorCode GAS_STATION_CODE_EXISTED =
            new BusinessErrorCode(4149, "Gas station with code %s is already existed", 400);

    public static final BusinessErrorCode PRODUCT_EXCHANGE_RATE_NOT_FOUND =
            new BusinessErrorCode(4116, "product exchange rate not found", 400);

    public static final BusinessErrorCode CONFLICT_VALUE_PRICE_N_VOLUMED =
            new BusinessErrorCode(4117,
                    "Your limit is not enough to create an order.Please check again.", 400);

    public static final BusinessErrorCode LIMIT_MONEY_NOT_FOUND =
            new BusinessErrorCode(4118, "limit cash money not found", 400);

    public static final BusinessErrorCode INVALID_MONEY_VALUE =
            new BusinessErrorCode(4119, "invalid money value", 400);

    public static final BusinessErrorCode INVALID_OIL_VALUE =
            new BusinessErrorCode(4120, "invalid oil value", 400);

    public static final BusinessErrorCode LIMIT_OIL_NOT_FOUND =
            new BusinessErrorCode(4121, "limit cash oil not found", 400);

    public static final BusinessErrorCode PRODUCT_TYPE_NOT_SUPPORT =
            new BusinessErrorCode(4122, "Product type not support", 400);

    public static final BusinessErrorCode PROVINCE_NOT_FOUND =
            new BusinessErrorCode(4163, "Province is null", 400);

    public static final BusinessErrorCode DISTRICT_NOT_FOUND =
            new BusinessErrorCode(4164, "District is null", 400);

    public static final BusinessErrorCode WARD_NOT_FOUND =
            new BusinessErrorCode(4165, "Ward is null", 400);

    public static final BusinessErrorCode CATEGORY_NOT_FOUND =
            new BusinessErrorCode(4123, "Category not found", 400);

    public static final BusinessErrorCode CATEGORY_CAN_NOT_DELETE =
            new BusinessErrorCode(4124, "Category can not delete", 400);

    public static final BusinessErrorCode CATEGORY_CAN_NOT_BE_MODIFIED =
            new BusinessErrorCode(4152, null, 400);

    public static final BusinessErrorCode CATEGORY_NAME_EXISTS =
            new BusinessErrorCode(4153, null, 400);

    public static final BusinessErrorCode CATEGORY_CODE_EXISTS =
            new BusinessErrorCode(4154, null, 400);

    public static final BusinessErrorCode MODULE_NOT_EXISTS =
            new BusinessErrorCode(4200, "Module does not exist", 400);

    public static final BusinessErrorCode COUNT_GENERATE_QR =
            new BusinessErrorCode(4520, "Count not Generate QR code", 400);

    public static final BusinessErrorCode ORDER_IS_CANCEL =
            new BusinessErrorCode(4530, "Order has been cancelled", 400);

    public static final BusinessErrorCode ORDER_IS_NOT_FOUND =
            new BusinessErrorCode(4531, "Order is not found", 400);

    public static final BusinessErrorCode ORDER_ARE_NOT_FOUND_OR_PROCESSING =
            new BusinessErrorCode(4533, "Order is not found or processing", 400);

    public static final BusinessErrorCode ORDER_ARE_WAIT_FOR_PAY =
            new BusinessErrorCode(4258, "Order is wait for pay", 400);

    public static final BusinessErrorCode ORDER_ARE_NOT_FOUND_OR_NOT_FINISH_PROCESSING =
            new BusinessErrorCode(4145, "Order is not found or not finish processing", 400);

    public static final BusinessErrorCode DATA_IS_NULL =
            new BusinessErrorCode(4532, "Data is null", 400);

    public static final BusinessErrorCode CASH_LIMIT_NOT_FOUND =
            new BusinessErrorCode(4256, "cash limit not found", 400);

    public static final BusinessErrorCode CASH_LIMIT_DETAIL_NOT_FOUND =
            new BusinessErrorCode(4257, "cash limit detail not found", 400);

    public static final BusinessErrorCode FIELD_SORT_INVALID =
            new BusinessErrorCode(4160, "FIELD_SORT_INVALID", 400);

    public static final BusinessErrorCode GROUP_PERMISSION_INVALID =
            new BusinessErrorCode(4178, "roles permission invalid", 400);

    public static final BusinessErrorCode USERNAME_IS_EXISTED =
            new BusinessErrorCode(4179, "username existed", 400);

    public static final BusinessErrorCode ACCOUNT_ROLE_IS_EXISTED =
            new BusinessErrorCode(4180, "account role existed", 400);

    public static final BusinessErrorCode CODE_IS_EXISTED =
            new BusinessErrorCode(4183, "code existed", 400);

    public static final BusinessErrorCode PROPERTIES_IS_NULL =
            new BusinessErrorCode(4203, "Properties id is null", 400);

    public static final BusinessErrorCode FILE_NOT_EXIST =
            new BusinessErrorCode(4971, "File id is not exist", 400);

    public static final BusinessErrorCode FILE_TOO_LARGE =
            new BusinessErrorCode(4201, "File to large", 400);

    public static final BusinessErrorCode ONLY_UPLOAD_10_FILES =
            new BusinessErrorCode(4202, "Only upload 10 file", 400);

    public static final BusinessErrorCode CONTENT_TYPE_NULL =
            new BusinessErrorCode(4205, "Content type null", 400);
    public static final BusinessErrorCode ROLE_IS_INDELIBLE =
            new BusinessErrorCode(4193, "cannot delete a role which is currently used", 400);

    public static final BusinessErrorCode ROLE_DOES_NOT_EXIST =
            new BusinessErrorCode(4195, "Role does not exist.", 400);

    public static final BusinessErrorCode ENTERPRISE_NOT_FOUND =
            new BusinessErrorCode(4807, "Enterprise not found", 400);

    public static final BusinessErrorCode GROUP_ID_INVALID =
            new BusinessErrorCode(4196, "GROUP ID INVALID", 400);

    public static final BusinessErrorCode FEATURE_ID_INVALID =
            new BusinessErrorCode(4197, "FEATURE ID INVALID", 400);

    public static final BusinessErrorCode GROUP_NOT_CONTAIN_THIS_FEATURE =
            new BusinessErrorCode(4198, "GROUP NOT CONTAIN THIS FEATURE", 400);

    public static final BusinessErrorCode LIMIT_MONEY_NOT_ENOUGH =
            new BusinessErrorCode(4199, "limit cash money not enough", 400);

    public static final BusinessErrorCode PROFILE_WITH_GIVEN_PHONE_DOES_NOT_EXIST =
            new BusinessErrorCode(4821, "Profile with this number is not found", 400);

    public static final BusinessErrorCode INVALID_VIETNAMESE_PHONE_NUMBER =
            new BusinessErrorCode(4811, "Wrong Vietnamese phone number", 400);

    public static final BusinessErrorCode ACCOUNT_NOT_FOUND_OR_DELETE =
            new BusinessErrorCode(4823, "Account with id %s not found or status delete", 400);

    public static final BusinessErrorCode ROLE_NAME_IS_EXIST =
            new BusinessErrorCode(4131, "Name role is exist", 400);

    public static final BusinessErrorCode ACCOUNT_NOT_FOUND_OR_PHONE_NUMBER_EXITS =
            new BusinessErrorCode(4854, "Account not fount or phone number exits", 400);

    public static final BusinessErrorCode PHOTO_VOUCHER_IS_NULL =
            new BusinessErrorCode(4208, "Photo voucher is null", 400);

    public static final BusinessErrorCode EMPLOYEE_NOT_EXIST =
            new BusinessErrorCode(4720, "Employee with this account id not exist ", 400);

    public static final BusinessErrorCode RANK_STOCK_NOT_EXIST =
            new BusinessErrorCode(4722, "Rank stock not exist", 400);

    public static final BusinessErrorCode RANK_NOT_FOUND =
            new BusinessErrorCode(4215, "Rank not found", 400);

    public static final BusinessErrorCode LIST_RANK_STOCK_DISCOUNT_INVALID =
            new BusinessErrorCode(4225, "List rank stock discount invalid ", 400);

    public static final BusinessErrorCode LICENSE_PLATE_IS_NOT_FOUND =
            new BusinessErrorCode(4224, "License plate is not found", 400);

    public static final BusinessErrorCode TYPE_IMAGE_WRONG_FORMAT =
            new BusinessErrorCode(4230, "Type image wrong format", 400);

    public static final BusinessErrorCode PROFILE_IS_NULL =
            new BusinessErrorCode(4240, "Properties type is null", 400);

    public static final BusinessErrorCode TAKE_A_PHOTO_LICENSE_PLATE =
            new BusinessErrorCode(4724, "You must take a photo of the license plate", 400);

    public static final BusinessErrorCode NON_PROPRIETARY_RESOURCES =
            new BusinessErrorCode(4242, "Non proprietary resources", 400);

    public static final BusinessErrorCode DATE_INVALID =
            new BusinessErrorCode(4248, "Date invalid ", 400);

    public static final BusinessErrorCode EMAIL_EXIST =
            new BusinessErrorCode(4247, "Email exist ", 400);

    public static final BusinessErrorCode ID_NUMBER_EXIST =
            new BusinessErrorCode(4246, "Identity card number exist ", 400);

    public static final BusinessErrorCode ORDER_ARE_BEING_PROCESSED =
            new BusinessErrorCode(7425, "Orders are being processed. ", 400);

    public static final BusinessErrorCode EXIST_EMPLOYEE_IN_STATION =
            new BusinessErrorCode(4254, "Exist employee in station ", 400);

    public static final BusinessErrorCode PUMP_POLE_HAS_WORKING_SCHEDULE =
            new BusinessErrorCode(4259, "Pump pole has working schedule ", 400);

    public static final BusinessErrorCode LOCK_SHIFT_NOT_FOUND =
            new BusinessErrorCode(4894, "Lock shift not found", 400);

    public static final BusinessErrorCode PROFILE_NOT_FOUND =
            new BusinessErrorCode(4903, "Profile not found", 400);

    public static final BusinessErrorCode PASSWORD_NEW_WRONG =
            new BusinessErrorCode(4952, "Wrong password new", 400);

    public static final BusinessErrorCode BANNER_IS_NOT_FOUND =
            new BusinessErrorCode(4293, "Banner is not found", 400);

    public static final BusinessErrorCode NEWS_IS_NOT_FOUND =
            new BusinessErrorCode(4970, "News is not found", 400);

    public static final BusinessErrorCode TITLE_IS_EXISTED =
            new BusinessErrorCode(4975, "Title existed", 400);



    static {
        Set<Integer> codes = new HashSet<>();
        var duplications = Arrays.stream(ErrorCode.class.getDeclaredFields())
                .filter(f -> Modifier.isStatic(f.getModifiers()) && f.getType().equals(BusinessErrorCode.class))
                .map(f -> {
                    try {
                        return ((BusinessErrorCode) f.get(null)).getCode();
                    } catch (IllegalAccessException e) {
                        log.error("can't load error code into map", e);
                        throw new RuntimeException(e);
                    }
                })
                .filter(code -> !codes.add(code))
                .collect(Collectors.toList());
        if (!duplications.isEmpty()) {
            throw new RuntimeException("Duplicate error code: " + duplications);
        }
    }
}
