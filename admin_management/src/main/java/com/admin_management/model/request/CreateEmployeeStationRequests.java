package com.admin_management.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
public class CreateEmployeeStationRequests {

    @JsonAttribute(name = "create_employee_station_requests")
    private List<CreateEmployeeStationRequest> createEmployeeStationRequests;
}
