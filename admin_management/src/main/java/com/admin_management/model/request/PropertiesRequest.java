package com.admin_management.model.request;

import com.admin_management.model.bo.DepartmentType;
import com.admin_management.model.bo.PropertiesCode;
import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class PropertiesRequest {

    private PropertiesCode code;

    @JsonAttribute(name = "department_type")
    @JsonProperty("department_type")
    private DepartmentType departmentType;
}
