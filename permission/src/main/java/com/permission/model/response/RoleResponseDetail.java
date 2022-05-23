package com.permission.model.response;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
public class RoleResponseDetail {

    @JsonAttribute(name = "role_responses")
    private List<RoleResponse> roleResponses;
}
