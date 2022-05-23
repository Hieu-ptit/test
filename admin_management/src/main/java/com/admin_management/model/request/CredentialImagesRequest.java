package com.admin_management.model.request;

import com.admin_management.model.bo.FaceImg;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CredentialImagesRequest {

    private int id;

    private String url;

    private String type;

    private String name;

    private FaceImg face;

}
