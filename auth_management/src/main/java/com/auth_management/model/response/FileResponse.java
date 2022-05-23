package com.auth_management.model.response;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class FileResponse {

    private Integer id;

    private String url;

    private String name;

}
