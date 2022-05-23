package com.admin_management.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class FilterEvaluation {

    private Integer stationId;

    private Integer employeeId;

    private LocalDate dateFrom;

    private LocalDate dateTo;

    private Integer page;

    private Integer size;
}
