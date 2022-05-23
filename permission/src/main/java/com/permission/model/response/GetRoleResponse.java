package com.permission.model.response;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GetRoleResponse {

    private Integer id;

    private String name;

    private String description;
}
