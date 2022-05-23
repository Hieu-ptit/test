package com.admin_management.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import java.util.Set;

@Data
@Accessors(chain = true)
@CompiledJson
public class UpdateRolesAccountRequest {

    @JsonAttribute(name = "account_id")
    @JsonProperty("account_id")
    private String accountId;

    @JsonAttribute(name = "role_ids")
    @JsonProperty("role_ids")
    private Set<Integer> roleIds;

    public String getAccountId() {
        return StringUtils.isBlank(accountId) ? null : accountId.trim();
    }
}
