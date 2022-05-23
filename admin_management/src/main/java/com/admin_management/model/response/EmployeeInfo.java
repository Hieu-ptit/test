package com.admin_management.model.response;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
public class EmployeeInfo {

    private Integer id;

    private String code;

    private String name;

    private PropertiesResponse department;

    private PropertiesResponse positions;

    private List<StationResponse> station;

}
