package com.admin_management.model.response;

import com.admin_management.model.bo.DepartmentType;
import com.admin_management.model.bo.PropertiesCode;
import com.admin_management.model.bo.PropertiesType;
import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class PropertiesResponse {

    private Integer id;

    private String name;

    private PropertiesType type;

    private PropertiesCode code;

    @JsonAttribute(name = "department_type")
    @JsonProperty("department_type")
    private DepartmentType departmentType;

}
