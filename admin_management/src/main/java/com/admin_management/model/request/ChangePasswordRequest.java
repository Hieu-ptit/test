package com.admin_management.model.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Pattern;

@Data
@Accessors(chain = true)
public class ChangePasswordRequest {

    @Pattern(regexp = "^(?=\\S+$)([!@#$%^&+/*|(),.;:~-]|[A-Za-z0-9]){8,32}$", message = "4953")
    private String passwordOld;

    @Pattern(regexp = "^(?=\\S+$)([!@#$%^&+/*|(),.;:~-]|[A-Za-z0-9]){8,32}$", message = "4953")
    private String passwordNew;

    @Pattern(regexp = "^(?=\\S+$)([!@#$%^&+/*|(),.;:~-]|[A-Za-z0-9]){8,32}$", message = "4953")
    private String repeatPassword;


    public String getPasswordOld() {
        return StringUtils.isBlank(passwordOld) ? null : passwordOld.trim();
    }

    public String getPasswordNew() {
        return StringUtils.isBlank(passwordNew) ? null : passwordNew.trim();
    }

    public String getRepeatPassword() {
        return StringUtils.isBlank(repeatPassword) ? null : repeatPassword.trim();
    }
}
