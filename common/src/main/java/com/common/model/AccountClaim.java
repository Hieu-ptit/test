package com.common.model;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;

@Data
@CompiledJson

public class AccountClaim {

    @JsonAttribute(name = "account_id")
    private String accountId;

    private String username;

    private String role;

    private String bitSet;

}
