package com.admin_management.model.bo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class LocationDetail {

    private int id;

    private String name;

}
