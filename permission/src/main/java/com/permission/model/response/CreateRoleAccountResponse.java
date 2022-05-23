package com.permission.model.response;


import com.permission.model.entity.RoleAccount;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class CreateRoleAccountResponse {
    private List<RoleAccount> roleAccounts;
}
