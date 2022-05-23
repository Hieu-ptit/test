package com.admin_management.model.response;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.AccessType;

import java.util.List;

@Data
@Accessors(chain = true)
public class EvaluationDetail {

    private Integer quantityFiveStar;

    private Integer quantityFourStar;

    private Integer quantityThreeStar;

    private Integer quantityTwoStar;

    private Integer quantityOneStar;

    private Double quantityMedium;

    private Integer page;

    private Integer size;

    private Long totalElement;

    private List<EvaluationResponse> evaluationResponses;


}
