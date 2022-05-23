package com.admin_management.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class AdminRegisterResponse extends AccountInfo {
    private String code;
    private String name;
}
