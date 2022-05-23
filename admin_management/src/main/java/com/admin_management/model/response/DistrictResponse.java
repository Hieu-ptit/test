package com.admin_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class DistrictResponse {

    private int id;

    private int provinceId;

    private String name;

    private String prefix;
}
