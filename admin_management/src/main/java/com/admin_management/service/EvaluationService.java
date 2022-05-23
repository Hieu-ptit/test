package com.admin_management.service;

import com.admin_management.model.request.EvaluationRequest;
import com.admin_management.model.request.EvaluationRequestDetail;
import com.admin_management.model.request.FilterEvaluation;
import com.admin_management.model.response.EvaluationDetail;
import com.admin_management.model.response.EvaluationInfo;
import com.admin_management.model.response.EvaluationResponseDetail;
import org.springframework.data.domain.Page;

import java.io.IOException;

public interface EvaluationService {

    EvaluationDetail filter(EvaluationRequestDetail request);

    String exportExcelAllWithFilter(EvaluationRequestDetail request);

    Page<EvaluationInfo> findByAccountId(String accountId, Integer vote, Integer page, Integer size);

    EvaluationResponseDetail getEvaluationDetail(EvaluationRequestDetail detail);

    String exportExcelsDetail(EvaluationRequestDetail detail) throws IllegalAccessException, IOException;

    Boolean create(EvaluationRequest request);
}
