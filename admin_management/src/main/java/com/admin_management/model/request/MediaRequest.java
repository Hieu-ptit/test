package com.admin_management.model.request;

import com.admin_management.model.response.TypeMedia;
import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class MediaRequest {

    private String name;

    private String url;

    private String owner;

    private TypeMedia type;

    public static MediaRequest build() {
        return new MediaRequest();
    }
}
