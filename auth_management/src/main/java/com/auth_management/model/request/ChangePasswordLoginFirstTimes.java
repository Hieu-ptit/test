package com.auth_management.model.request;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordLoginFirstTimes {

    @NotBlank(message = "4024")
    private String id;

    @NotBlank(message = "4023")
    private String password;

    public String getId() {
        return StringUtils.isBlank(id) ? null : id.trim();
    }

    public String getPassword() {
        return StringUtils.isBlank(password) ? null : password.trim();
    }

}
