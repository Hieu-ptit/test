package com.auth_management.model.response;

import com.auth_management.model.bo.BaseBusinessObject;
import com.common.model.bo.AccountStatus;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountAuth extends BaseBusinessObject {

    private String username;

    @JsonAttribute(name = "account_id")
    private String accountId;

    private AccountStatus status;

    private String code;

    private CredentialImages avatar;

    private String name;

    private String phone;

    private Boolean otp;

}
