package com.admin_management.model.response;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class QrCodeImage {

    private Integer id;

    private String url;

    @JsonAttribute(name = "type_media")
    @JsonProperty("type_media")
    private TypeMedia typeMedia;

}
