package com.admin_management.converter;


import com.admin_management.model.bo.LocationDetail;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class JsonConvertLocation implements AttributeConverter<LocationDetail, String> {
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(LocationDetail objectValue) {
        if (objectValue == null) return null;

        try {
            return mapper.writeValueAsString(objectValue);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to serialize to json field", e);
        }
    }

    @Override
    public LocationDetail convertToEntityAttribute(String dataValue) {
        if (dataValue == null) return null;

        try {
            return mapper.readValue(dataValue, new TypeReference<LocationDetail>() {
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to serialize to json field", e);
        }
    }
}
