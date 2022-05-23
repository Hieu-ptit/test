package com.admin_management.model.request;

import com.admin_management.validator.Login;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@Login
public class LoginRequest {

    private String username;

    private String password;

    public String getUsername() {
        return StringUtils.isBlank(username) ? null : username.trim();
    }

    public String getPassword() {
        return StringUtils.isBlank(password) ? null : password.trim();
    }
}
