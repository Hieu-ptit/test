package com.admin_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EmployeeResponse {

    private Integer id;

    private String name;

    private String code;

    private String positionName;

}
