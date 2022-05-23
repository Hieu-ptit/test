package com.admin_management.model.response;

import com.admin_management.caller.StationNameResponse;
import com.admin_management.model.bo.BaseBusinessObject;
import com.admin_management.model.bo.CredentialImages;
import com.common.model.bo.AccountStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class AccountInfo extends BaseBusinessObject {

    private String accountId;

    private String code;

    private String username;

    private CredentialImages avatar;

    private String name;

    private String phone;

    private AccountStatus status;

    private String position;

    private Boolean otp;

    private List<StationNameResponse> stationNames;

    public static AccountInfo build() {
        return new AccountInfo();
    }

}
