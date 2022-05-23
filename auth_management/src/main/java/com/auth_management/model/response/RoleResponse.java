package com.auth_management.model.response;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
@CompiledJson
public class RoleResponse {

    private int id;

    private String name;

    @JsonAttribute(name = "bit_set_module")
    private Map<String, Integer> bitSetModule;
}
