package com.auth_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ImageSpeedometerResponse {

    private String url;

    private Integer speedometer;

}
