package com.common.model;

import com.dslplatform.json.CompiledJson;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@CompiledJson
public enum Gender {
    MALE, FEMALE, UNDEFINED;
    private static Map<String, Gender> values = Arrays.stream(Gender.values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static Gender of(String value) {
        return values.get(value);
    }

    public static Gender of(String value, Gender defaultValue) {
        var gender = values.get(value);
        return gender != null ? gender : defaultValue;
    }
}
