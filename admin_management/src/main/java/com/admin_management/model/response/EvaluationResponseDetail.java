package com.admin_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Data
@Accessors(chain = true)
public class EvaluationResponseDetail {

    private List<EvaluationDetails> evaluationDetails;

    private Integer oneStar;

    private Integer twoStar;

    private Integer threeStar;

    private Integer fourStar;

    private Integer fiveStar;

    private String codeEmployee;

    private String nameEmployee;

    private Integer page;

    private Integer size;

    private Long totalElement;

}
