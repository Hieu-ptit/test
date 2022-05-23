package com.auth_management.model.response;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
public class MediaResponse {

    @JsonAttribute(name = "file_responses")
    private List<FileResponse> fileResponses;

}
