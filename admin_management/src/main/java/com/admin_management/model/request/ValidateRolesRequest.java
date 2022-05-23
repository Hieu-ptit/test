package com.admin_management.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
@CompiledJson
public class ValidateRolesRequest {
    @JsonAttribute(name = "role_ids")
    @JsonProperty("role_ids")
    private Set<Integer> roleIds;
}
