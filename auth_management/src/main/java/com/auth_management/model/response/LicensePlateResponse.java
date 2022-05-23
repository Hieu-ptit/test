package com.auth_management.model.response;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
public class LicensePlateResponse {

    private String message;

    @JsonAttribute(name = "result")
    private List<ResultResponse> result;

    private String status;
}
