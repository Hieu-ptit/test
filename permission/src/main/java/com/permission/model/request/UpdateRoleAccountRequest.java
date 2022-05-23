package com.permission.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Accessors(chain = true)
@CompiledJson
public class UpdateRoleAccountRequest {

    @JsonAttribute(name = "account_id")
    @JsonProperty("account_id")
    private String accountId;

    @NotNull(message = "4071")
    @JsonAttribute(name = "role_ids")
    @JsonProperty("role_ids")
    private Set<@NotNull Integer> roleIds;
}
