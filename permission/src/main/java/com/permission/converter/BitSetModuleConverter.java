package com.permission.converter;

import com.common.util.Json;
import com.permission.util.Global;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Converter(autoApply = true)
public class BitSetModuleConverter implements AttributeConverter<Map<String, Integer>, String> {

    @Override
    public String convertToDatabaseColumn(Map<String, Integer> objectValue) {
        if (objectValue == null) return null;

        return Json.encodeToString(objectValue);
    }

    @Override
    public Map<String, Integer> convertToEntityAttribute(String dataValue) {
        if (dataValue == null) return null;

        return Json.decode(dataValue.getBytes(StandardCharsets.UTF_8), Global.mapReader);
    }
}