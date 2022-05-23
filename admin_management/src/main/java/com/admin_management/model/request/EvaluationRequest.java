package com.admin_management.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EvaluationRequest {

    private String code;

    private Integer stationId;

    private String driverId;

    private String content;

    private Integer vote;

    private Integer employeeId;
}
