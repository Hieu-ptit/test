package com.permission.model.request;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@CompiledJson
public class HistoryRequest {

    String code;

    String name;

    String description;
}
