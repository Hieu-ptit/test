package com.auth_management.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class ImageLicensePlatesRequest {

    @JsonAttribute(name = "account_id")
    private String accountId;

    @JsonAttribute(name = "order_id")
    private Integer orderId;

    private String url;

    private String date;

    private String name;
}
