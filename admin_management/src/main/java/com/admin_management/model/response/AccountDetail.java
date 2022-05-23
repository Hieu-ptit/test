package com.admin_management.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AccountDetail extends AccountInfo {

    private String name;

    private List<Integer> roleIds;

    private Integer employeeId;

    private String employeeCode;

    private String employeeName;
}
