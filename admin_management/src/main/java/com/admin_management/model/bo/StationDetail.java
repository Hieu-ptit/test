package com.admin_management.model.bo;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

@Data
@Accessors(chain = true)
@CompiledJson
public class StationDetail {

    private int id;

    private String code;

    @NotBlank(message = "4239")
    private String name;
}
