package com.admin_management.caller;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class StationNameResponse {

    private Integer id;

    private String name;

    public static StationNameResponse build() {
        return new StationNameResponse();
    }
}
