package com.admin_management.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class AccountResponse extends AccountInfo {

    private String name;

    private Integer employeeId;

    private String employeeName;

    private String employeeCode;

    public AccountResponse(AccountInfo accountInfo) {
        this.setAccountId(accountInfo.getAccountId());
        this.setStatus(accountInfo.getStatus());
        this.setUsername(accountInfo.getUsername());
        this.setCode(accountInfo.getCode());
        this.setCreatedAt(accountInfo.getCreatedAt());
        this.setUpdatedAt(accountInfo.getUpdatedAt());
    }
}
