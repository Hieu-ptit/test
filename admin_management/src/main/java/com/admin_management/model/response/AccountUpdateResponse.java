package com.admin_management.model.response;

import com.common.model.bo.AccountStatus;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AccountUpdateResponse {

    private String code;

    private String username;

    private AccountStatus status;
}
