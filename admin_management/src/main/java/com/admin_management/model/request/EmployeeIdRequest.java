package com.admin_management.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;
import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
@Valid
public class EmployeeIdRequest {

    @JsonAttribute(name = "employee_ids")
    @JsonProperty("employee_ids")
    List<Integer> employeeIds;
}
