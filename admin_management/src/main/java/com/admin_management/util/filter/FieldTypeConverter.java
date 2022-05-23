package com.admin_management.util.filter;

import com.admin_management.util.BusinessDateTimeUtil;
import com.common.exception.BusinessException;
import com.common.util.ErrorCode;

import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

public final class FieldTypeConverter {

    private FieldTypeConverter() {
    }

    public static BiFunction<String, String, Integer> CONVERT_INTEGER_FUNCTION = (fieldName, fieldValue) -> {
        try {
            return Integer.valueOf(fieldValue);
        } catch (NumberFormatException e) {
            throw new BusinessException(ErrorCode.NUMBER_FORMAT_ERROR, String.format("Invalid value %s for field %s, accepted type is Integer", fieldValue, fieldName));
        }
    };


    public static BiFunction<String, String, Long> CONVERT_LONG_FUNCTION = (fieldName, fieldValue) -> {
        try {
            return Long.valueOf(fieldValue);
        } catch (NumberFormatException e) {
            throw new BusinessException(ErrorCode.NUMBER_FORMAT_ERROR, String.format("Invalid value %s for field %s, accepted type is Long", fieldValue, fieldName));
        }
    };


    public static BiFunction<String, String, Float> CONVERT_FLOAT_FUNCTION = (fieldName, fieldValue) -> {
        try {
            return Float.valueOf(fieldValue);
        } catch (NumberFormatException e) {
            throw new BusinessException(ErrorCode.NUMBER_FORMAT_ERROR, String.format("Invalid value %s for field %s, accepted type is float", fieldValue, fieldName));
        }
    };


    public static BiFunction<String, String, Boolean> CONVERT_BOOLEAN_FUNCTION = (fieldName, fieldValue) -> {
        Pattern booleanPattern = Pattern.compile("(^true$)|(^false$)");
        if (!booleanPattern.matcher(fieldValue).matches())
            throw new BusinessException(ErrorCode.BOOLEAN_FORMAT_ERROR, String.format("Invalid value %s for field %s, accepted type is boolean", fieldValue, fieldName));

        return Boolean.parseBoolean(fieldValue);
    };


    public static BiFunction<String, String, String> CONVERT_STRING_FUNCTION = (fieldName, fieldValue) -> fieldValue;


    public static BiFunction<String, String, OffsetDateTime> CONVERT_DATE_FUNCTION = (fieldName, fieldValue) -> {
        try {
            return OffsetDateTime.parse(fieldValue, BusinessDateTimeUtil.FORMATTER);
        } catch (DateTimeParseException e) {
            throw new BusinessException(ErrorCode.FORMAT_DATE_INVALID, String.format("Invalid value %s for field %s, accepted type is date", fieldValue, fieldName));
        }
    };

    public static BiFunction<String, String, Enum> CONVERT_ENUM_FUNCTION(Map<String, Enum> enumFieldValue) {
        return (fieldName, fieldValue) -> {
            Enum enumValue = enumFieldValue.get(fieldValue);
            if (enumValue == null)
                throw new BusinessException(ErrorCode.ENUM_FIELD_VALUE_INVALID, String.format("Invalid value %s for field %s, accepted type is enum", fieldValue, fieldName));

            return enumValue;
        };
    }
}
