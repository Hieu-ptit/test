package com.admin_management.model.request;

import com.common.model.bo.AccountStatus;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Data
@Accessors(chain = true)
public class EmployeeRegisterRequest {

    @NotNull(message = "4255")
    private Integer employeeId;

    @NotBlank(message = "4177")
    @Pattern(regexp = "^[^\\s]{1,99}$", message = "4182")
    private String username;

    @NotBlank(message = "4176")
    @Pattern(regexp = "^[^-\\s]{8,32}$", message = "4181")
    private String password;

    @NotNull(message = "4170")
    private AccountStatus status;

    @NotNull(message = "4071")
    @JsonAttribute(name = "role_ids")
    @JsonProperty("role_ids")
    private Set<@NotNull Integer> roleIds;

    public String getUsername() {
        return StringUtils.isBlank(username) ? null : username.trim();
    }

    public String getPassword() {
        return StringUtils.isBlank(password) ? null : password.trim();
    }

}
