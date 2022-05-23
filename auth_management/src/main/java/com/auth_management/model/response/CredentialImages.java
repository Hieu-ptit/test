package com.auth_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CredentialImages {

    private int id;

    private String url;

    private String type;

    private String name;

}