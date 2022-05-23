package com.admin_management.model.request;

import com.admin_management.model.bo.CredentialImages;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class AvatarRequest {

    @NotNull(message = "4950")
    private CredentialImages avatar;
}
