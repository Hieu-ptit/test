package com.admin_management.converter;

import com.admin_management.model.response.StationResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;

public class JsonConverterStation implements AttributeConverter<StationResponse, String> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(StationResponse attribute) {
        if (attribute == null) return null;

        try {
            return mapper.writeValueAsString(attribute);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to serialize to json field", e);
        }
    }

    @Override
    public StationResponse convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        try {
            return mapper.readValue(dbData, new TypeReference<>() {
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to serialize to json field", e);
        }
    }
}
