package com.admin_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class EvaluationDetails {

    private LocalDate date;

    private String code;

    private String stationName;

    private Integer vote;

    private String content;

    private Integer employeeId;

    private String codeEmployee;

    private String nameEmployee;

}
