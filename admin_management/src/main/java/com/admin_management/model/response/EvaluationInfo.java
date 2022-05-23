package com.admin_management.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.ZonedDateTime;

@Data
@Accessors(chain = true)
public class EvaluationInfo {

    private Integer vote;

    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm - dd/MM/yyyy ")
    private ZonedDateTime createdAt;
}
