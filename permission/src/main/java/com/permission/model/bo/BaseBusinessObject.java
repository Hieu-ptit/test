package com.permission.model.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class BaseBusinessObject {

    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

}
