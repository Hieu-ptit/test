package com.permission.model.response;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
@CompiledJson
public class RoleResponse {

    private int id;

    private String name;

    private Map<String, Integer> bitSetModule;
}
