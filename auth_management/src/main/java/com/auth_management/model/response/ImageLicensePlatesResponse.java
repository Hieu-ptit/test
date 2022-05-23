package com.auth_management.model.response;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class ImageLicensePlatesResponse {

    private String url;

    @JsonAttribute(name = "license_plate")
    private String licensePlate;

    @JsonAttribute(name = "license_plate_valid")
    private Boolean licensePlateValid;

}
