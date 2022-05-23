package com.admin_management.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
public class OtpRequest {

    @NotBlank
    private String phone;

    private boolean authentication;

    @NotBlank
    private String idToken;
}
