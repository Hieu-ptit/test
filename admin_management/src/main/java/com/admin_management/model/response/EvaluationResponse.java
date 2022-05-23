package com.admin_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class EvaluationResponse {

    private Integer employeeId;

    private String accountId;

    private String code;

    private String name;

    private Integer fiveStar;

    private Integer fourStar;

    private Integer threeStar;

    private Integer twoStar;

    private Integer oneStar;

    private Double voteMedium;

    private Integer pointEvaluation;

    private String content;

    private Integer totalPoint;

}
