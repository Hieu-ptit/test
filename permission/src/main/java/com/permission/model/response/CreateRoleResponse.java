package com.permission.model.response;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Data
@Accessors(chain = true)
public class CreateRoleResponse {

    private Integer id;

    private String name;

    private String description;

    private List<Map<String, ?>> bitSetModule;
}
