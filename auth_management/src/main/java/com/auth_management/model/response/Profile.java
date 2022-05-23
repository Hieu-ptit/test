package com.auth_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Profile {

    private int id;

    private String name;

    private String address;

    private String avatar;
}
