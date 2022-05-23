package com.admin_management.model.request;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.Valid;

@Data
@Accessors(chain = true)
@CompiledJson
@Valid
@EqualsAndHashCode(callSuper = true)
public class CreateEmployeeRequest extends UpsertEmployeeRequest {

    private String code;
}
