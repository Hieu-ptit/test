package com.admin_management.model.request;

import com.admin_management.model.bo.TableValidate;
import com.admin_management.validator.IdIsExist;
import com.common.annotation.Password;
import com.common.model.TotalStatus;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;

@Data
public class ChangePasswordLoginFirstTimes {

    @NotBlank(message = "4024")
    @IdIsExist(status = TotalStatus.FIRST, tableValidate = TableValidate.ACCOUNT)
    private String id;

    @Password
    @NotBlank(message = "4023")
    private String password;

    public String getPassword() {
        return StringUtils.isBlank(password) ? null : password.trim();
    }

}
