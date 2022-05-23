package com.admin_management.model.request;

import com.common.model.bo.AccountStatus;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
@Accessors(chain = true)
public class AccountUpdateRequest {

    @NotNull(message = "4255")
    private Integer employeeId;

    @NotNull(message = "4170")
    private AccountStatus status;

    @NotNull(message = "4071")
    @JsonAttribute(name = "role_ids")
    @JsonProperty("role_ids")
    private Set<Integer> roleIds;

}
