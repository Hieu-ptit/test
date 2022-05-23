package com.admin_management.model.response;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class StationResponse {
    private int id;

    private String name;

    private String address;

    private String code;

    @JsonAttribute(name = "full_address")
    private String fullAddress;

    @JsonAttribute(name = "province_id")
    private int provinceId;

    @JsonAttribute(name = "district_id")
    private int districtId;

    private int wardId;
}
