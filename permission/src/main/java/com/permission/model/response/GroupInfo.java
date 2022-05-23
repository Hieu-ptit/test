package com.permission.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class GroupInfo {

    private String code;

    private String name;
}
