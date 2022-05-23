package com.admin_management.model.response;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class RoleResponse {

    private int id;

    private String name;
}
