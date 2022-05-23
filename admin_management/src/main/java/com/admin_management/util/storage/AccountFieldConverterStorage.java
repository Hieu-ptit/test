package com.admin_management.util.storage;

import com.common.model.Gender;
import com.common.model.bo.AccountStatus;
import com.admin_management.util.filter.FieldTypeConverter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AccountFieldConverterStorage {
    public static final Map<String, BiFunction<String, String, ?>> TYPE_CONVERTERS = new HashMap<>();

    static {
        Map<String, Enum> ACCOUNT_STATUS_VALUES = Arrays.stream(AccountStatus.values()).collect(Collectors.toMap(AccountStatus::name, Function.identity()));
        Map<String, Enum> ACCOUNT_GENDER_VALUES = Arrays.stream(Gender.values()).collect(Collectors.toMap(Gender::name, Function.identity()));
        TYPE_CONVERTERS.put("id", FieldTypeConverter.CONVERT_INTEGER_FUNCTION);
        TYPE_CONVERTERS.put("accountNo", FieldTypeConverter.CONVERT_STRING_FUNCTION);
        TYPE_CONVERTERS.put("phoneNumber", FieldTypeConverter.CONVERT_STRING_FUNCTION);
        TYPE_CONVERTERS.put("nickname", FieldTypeConverter.CONVERT_STRING_FUNCTION);
        TYPE_CONVERTERS.put("vip", FieldTypeConverter.CONVERT_INTEGER_FUNCTION);
        TYPE_CONVERTERS.put("experience", FieldTypeConverter.CONVERT_LONG_FUNCTION);
        TYPE_CONVERTERS.put("level", FieldTypeConverter.CONVERT_INTEGER_FUNCTION);
        TYPE_CONVERTERS.put("createdAt", FieldTypeConverter.CONVERT_DATE_FUNCTION);
        TYPE_CONVERTERS.put("streamer", FieldTypeConverter.CONVERT_BOOLEAN_FUNCTION);
        TYPE_CONVERTERS.put("status", FieldTypeConverter.CONVERT_ENUM_FUNCTION(ACCOUNT_STATUS_VALUES));
        TYPE_CONVERTERS.put("gender", FieldTypeConverter.CONVERT_ENUM_FUNCTION(ACCOUNT_GENDER_VALUES));

    }

    private AccountFieldConverterStorage() {
    }
}

