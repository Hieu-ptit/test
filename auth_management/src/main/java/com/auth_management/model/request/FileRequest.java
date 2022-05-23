package com.auth_management.model.request;

import com.auth_management.model.bo.TypeMedia;
import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class FileRequest {

    private String name;

    private String url;

    private String owner;

    @JsonAttribute(name = "type_media")
    private TypeMedia typeMedia;

}
