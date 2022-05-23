package com.admin_management.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.Valid;

@Data
@Accessors(chain = true)
@Valid
@CompiledJson
public class CreateEmployeeStationRequest {

    @JsonAttribute(name = "employee_id")
    private Integer employeeId;

    @JsonAttribute(name = "station_id")
    private Integer stationId;
}
