package com.auth_management.model.request;

import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
public class CreateFile {

    @JsonAttribute(name = "files_request")
    private List<FileRequest> filesRequest;

}
