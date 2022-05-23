package com.permission.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ModuleResponse {

    private int id;

    private String name;

    private boolean checked;

    private List<GroupResponse> groups;
}
