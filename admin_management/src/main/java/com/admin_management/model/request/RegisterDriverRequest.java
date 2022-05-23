package com.admin_management.model.request;

import com.common.annotation.Otp;
import com.common.annotation.Password;
import com.common.model.TypeVerify;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;

@Data
public class RegisterDriverRequest {

    @Otp(type = TypeVerify.VERIFY)
    @NotEmpty
    private String otp;

    @NotEmpty
    @Password
    private String password;

    public String getOtp() {
        return StringUtils.isBlank(otp) ? null : otp.trim();
    }

    public String getPassword() {
        return StringUtils.isBlank(password) ? null : password.trim();
    }
}
