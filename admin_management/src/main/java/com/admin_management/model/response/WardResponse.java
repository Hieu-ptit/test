package com.admin_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class WardResponse {

    private int id;

    private String prefix;

    private String name;

    private int provinceId;

    private int districtId;
}
