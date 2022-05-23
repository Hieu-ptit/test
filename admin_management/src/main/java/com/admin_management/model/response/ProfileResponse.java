package com.admin_management.model.response;

import com.admin_management.model.bo.CredentialImages;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@Data
@Accessors(chain = true)
public class ProfileResponse {

    private Integer id;

    private String accountId;

    private String name;

    private String idCard;

    private OffsetDateTime dateOfBirth;

    private String email;

    private CredentialImages avatar;

    private String location;

    private String code;

    private String phone;

}
