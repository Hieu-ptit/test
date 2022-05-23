package com.admin_management.mapper;

import com.admin_management.model.entity.Evaluation;
import com.admin_management.model.response.*;
import com.google.common.util.concurrent.AtomicDouble;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.DecimalFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class EvaluationMapper {
    private final DecimalFormat doubleFormat = new DecimalFormat("#,##0.0");

    public EvaluationResponse map(DetailEmployeeResponse employee, List<Evaluation> evaluations) {

        EvaluationResponse response = new EvaluationResponse()
                .setEmployeeId(employee.getEmployeeId())
                .setAccountId(employee.getAccountId())
                .setCode(employee.getCode())
                .setName(employee.getName());

        AtomicInteger oneStar = new AtomicInteger();
        AtomicInteger twoStar = new AtomicInteger();
        AtomicInteger threeStar = new AtomicInteger();
        AtomicInteger fourStar = new AtomicInteger();
        AtomicInteger fiveStar = new AtomicInteger();
        AtomicInteger pointEvaluation = new AtomicInteger();
        AtomicInteger totalPoint = new AtomicInteger();

        evaluations.forEach(it -> {
            switch (it.getVote()) {
                case 1:
                    oneStar.set(oneStar.get() + 1);
                    pointEvaluation.set(pointEvaluation.get() + 1);
                    break;
                case 2:
                    twoStar.set(twoStar.get() + 1);
                    pointEvaluation.set(pointEvaluation.get() + 2);
                    break;
                case 3:
                    threeStar.set(threeStar.get() + 1);
                    pointEvaluation.set(pointEvaluation.get() + 3);
                    break;
                case 4:
                    fourStar.set(fourStar.get() + 1);
                    pointEvaluation.set(pointEvaluation.get() + 4);
                    break;
                case 5:
                    fiveStar.set(fiveStar.get() + 1);
                    pointEvaluation.set(pointEvaluation.get() + 5);
                    break;
            }
            totalPoint.set(totalPoint.get() + 1);
        });
        response.setOneStar(oneStar.intValue())
                .setTwoStar(twoStar.intValue())
                .setThreeStar(threeStar.intValue())
                .setFourStar(fourStar.intValue())
                .setFiveStar(fiveStar.intValue())
                .setPointEvaluation(pointEvaluation.intValue())
                .setTotalPoint(totalPoint.intValue())
                .setVoteMedium(Double.valueOf(doubleFormat.format(pointEvaluation.doubleValue() / totalPoint.doubleValue())));

        return response;
    }

    public List<EvaluationDetails> mapToResponse(List<Evaluation> evaluations) {
                return evaluations.stream().map(this::mapToResponseDetail).collect(Collectors.toList());
    }

    public EvaluationDetails mapToResponseDetail(Evaluation evaluations) {

        return new EvaluationDetails().setCode(evaluations.getOrderCode())
                .setVote(evaluations.getVote())
                .setEmployeeId(evaluations.getEmployee().getEmployeeId())
                .setStationName(evaluations.getStation().getName())
                .setCodeEmployee(evaluations.getEmployee().getCode())
                .setContent(evaluations.getContent())
                .setNameEmployee(evaluations.getEmployee().getName())
                .setDate(evaluations.getCreatedAt().toLocalDate());
    }


    public EvaluationDetail map(List<EvaluationResponse> evaluationResponses, int page, int size, long totalElement) {

        if (CollectionUtils.isEmpty(evaluationResponses))
            return new EvaluationDetail()
                    .setPage(page)
                    .setSize(size)
                    .setTotalElement(totalElement);

        AtomicInteger quantityOneStar = new AtomicInteger();
        AtomicInteger quantityTwoStar = new AtomicInteger();
        AtomicInteger quantityThreeStar = new AtomicInteger();
        AtomicInteger quantityFourStar = new AtomicInteger();
        AtomicInteger quantityFiveStar = new AtomicInteger();
        AtomicDouble totalMedium = new AtomicDouble();

        evaluationResponses.forEach(it -> {
            quantityOneStar.set(quantityOneStar.get() + it.getOneStar());
            quantityTwoStar.set(quantityTwoStar.get() + it.getTwoStar());
            quantityThreeStar.set(quantityThreeStar.get() + it.getThreeStar());
            quantityFourStar.set(quantityFourStar.get() + it.getFourStar());
            quantityFiveStar.set(quantityFiveStar.get() + it.getFiveStar());
            totalMedium.set(totalMedium.get() + it.getVoteMedium());
        });

        return new EvaluationDetail()
                .setQuantityOneStar(quantityOneStar.intValue())
                .setQuantityTwoStar(quantityTwoStar.intValue())
                .setQuantityThreeStar(quantityThreeStar.intValue())
                .setQuantityFourStar(quantityFourStar.intValue())
                .setQuantityFiveStar(quantityFiveStar.intValue())
                .setEvaluationResponses(evaluationResponses)
                .setPage(page)
                .setSize(size)
                .setTotalElement(totalElement)
                .setQuantityMedium(Double.valueOf(doubleFormat.format(totalMedium.doubleValue() / evaluationResponses.size())));
    }

    public List<EvaluationInfo> mapTo(Page<Evaluation> evaluations) {
        return evaluations.stream().map(this::map).collect(Collectors.toList());
    }

    private EvaluationInfo map(Evaluation evaluation) {

        return new EvaluationInfo()
                .setVote(evaluation.getVote())
                .setCreatedAt(evaluation.getCreatedAt())
                .setContent(evaluation.getContent());
    }
}
