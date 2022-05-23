package com.admin_management.converter;

import com.admin_management.model.response.FileResponse;
import com.admin_management.util.Global;
import com.common.util.Json;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Converter(autoApply = true)
public class JsonConverterAttachmentList implements AttributeConverter<List<FileResponse>, String> {

    @Override
    public String convertToDatabaseColumn(List<FileResponse> attribute) {
        if (attribute == null) return null;

        return Json.encodeToString(attribute);
    }

    @Override
    public List<FileResponse> convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        return Json.decode(dbData.getBytes(StandardCharsets.UTF_8), Global.listAttachmentReader);
    }
}
