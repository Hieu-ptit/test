package com.admin_management.service.impl;

import com.admin_management.caller.GasStationCaller;
import com.admin_management.caller.MediaCaller;
import com.admin_management.caller.PublicManagementCaller;
import com.admin_management.mapper.EvaluationMapper;
import com.admin_management.model.bo.MessageExcels;
import com.admin_management.model.entity.Evaluation;
import com.admin_management.model.request.EvaluationRequest;
import com.admin_management.model.request.EvaluationRequestDetail;
import com.admin_management.model.request.MediaRequest;
import com.admin_management.model.response.*;
import com.admin_management.repository.EvaluationRepository;
import com.admin_management.service.EmployeeInternalService;
import com.admin_management.service.EvaluationService;
import com.admin_management.util.Global;
import com.common.exception.BusinessException;
import com.common.model.response.Response;
import com.common.util.Constant;
import com.common.util.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.criteria.Predicate;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository repository;
    private final EvaluationMapper mapper;
    private final EmployeeInternalService internalService;
    private final GasStationCaller caller;
    private final ExcelService excelService;
    private final PublicManagementCaller managementCaller;
    private final MediaCaller mediaCaller;

    @Value("${app.server.upload.domain}")
    private String domain;
    @Value("${app.server.excels.evaluation.employee.path}")
    private String templateExcels;
    @Value("${app.server.excels.evaluation-detail.employee.path}")
    private String templateEvaluation;

    @Override
    public EvaluationDetail filter(EvaluationRequestDetail filterRequest) {
        Pageable pageable = PageRequest.of(filterRequest.getPage(), filterRequest.getSize(), Sort.by("createdAt").descending());

        Page<EvaluationResponse> responsePage = createPageFromList(getEvaluationResponse(filterRequest), pageable);

        return mapper.map(responsePage.getContent(), responsePage.getPageable().getPageNumber(), responsePage.getPageable().getPageSize(), responsePage.getTotalElements());
    }

    @Override
    @SneakyThrows
    public String exportExcelAllWithFilter(EvaluationRequestDetail filterRequest) {
        EvaluationDetail evaluations = mapper.map(getEvaluationResponse(filterRequest), 0, 0, 0);

        XSSFWorkbook workbook = excelService.exportExcelsEvaluation(evaluations, filterRequest, MessageExcels.FIELD_EVALUATION, templateExcels);

        String path = excelService.writeFileExcel(workbook, MessageExcels.TITLE);

        Boolean isInsertedSuccess = mediaCaller.insertIntoMedia(MediaRequest.build().setName(MessageExcels.TITLE).setType(TypeMedia.EXCEL).setUrl(path)).join().getData();
        if (!isInsertedSuccess)
            throw new BusinessException(ErrorCode.INSERT_INTO_MEDIA_FAIL, ErrorCode.INSERT_INTO_MEDIA_FAIL.getMessage());

        return domain + ("/images/" + path);
    }

    @Override
    public Page<EvaluationInfo> findByAccountId(String accountId, Integer vote, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());

        Page<Evaluation> evaluations = repository.findAll(buildPredicates(accountId, vote),pageable);

        List<EvaluationInfo> evaluationResponses = mapper.mapTo(evaluations);

        return createPageFromList(evaluationResponses, pageable);
    }

    @Override
    public EvaluationResponseDetail getEvaluationDetail(EvaluationRequestDetail detail) {

        Pageable pageable = PageRequest.of(detail.getPage(), detail.getSize(), Sort.by("createdAt").descending());
        List<Evaluation> evaluations = repository.findAll(buildPredicates(detail));
        List<EvaluationDetails> responseDetails = mapper.mapToResponse(evaluations);
        DetailEmployeeResponse response = internalService.findById(detail.getEmployeeId());
        EvaluationResponseDetail evaluationResponseDetail = new EvaluationResponseDetail();
        evaluationResponseDetail.setCodeEmployee(response.getCode());
        evaluationResponseDetail.setNameEmployee(response.getName());

        AtomicInteger quantityOneStar = new AtomicInteger();
        AtomicInteger quantityTwoStar = new AtomicInteger();
        AtomicInteger quantityThreeStar = new AtomicInteger();
        AtomicInteger quantityFourStar = new AtomicInteger();
        AtomicInteger quantityFiveStar = new AtomicInteger();

        evaluations.forEach(it -> {
            switch (it.getVote()) {
                case 1:
                    quantityOneStar.set(quantityOneStar.get() + 1);
                    break;
                case 2:
                    quantityTwoStar.set(quantityTwoStar.get() + 1);
                    break;
                case 3:
                    quantityThreeStar.set(quantityThreeStar.get() + 1);
                    break;
                case 4:
                    quantityFourStar.set(quantityFourStar.get() + 1);
                    break;
                case 5:
                    quantityFiveStar.set(quantityFiveStar.get() + 1);
                    break;
            }
        });

        evaluationResponseDetail.setOneStar(quantityOneStar.intValue());
        evaluationResponseDetail.setTwoStar(quantityTwoStar.intValue());
        evaluationResponseDetail.setThreeStar(quantityThreeStar.intValue());
        evaluationResponseDetail.setFourStar(quantityFourStar.intValue());
        evaluationResponseDetail.setFiveStar(quantityFiveStar.intValue());

        Page<EvaluationDetails> evaluationDetails = createPageFromList(responseDetails, pageable);
        return evaluationResponseDetail.setPage(evaluationDetails.getPageable().getPageNumber())
                .setEvaluationDetails(evaluationDetails.getContent())
                .setSize(evaluationDetails.getPageable().getPageSize())
                .setTotalElement(evaluationDetails.getTotalElements());
    }

    @Override
    public String exportExcelsDetail(EvaluationRequestDetail detail) throws IllegalAccessException, IOException {

        EvaluationResponseDetail paging = getEvaluationDetail(detail);
        String title = "Danh_sách_chi_tiet_danh_gia_";

        XSSFWorkbook workbook = excelService.exportExcels(paging, detail, Global.bodyEvaluation, templateEvaluation);

        String name = title + Constant.generateUUID() + ".xlsx";
        String path = excelService.writeFileExcel(workbook, name);

        String url = "/images/" + path;

        Boolean isInsertedSuccess = mediaCaller.insertIntoMedia(MediaRequest.build().setName(name).setType(TypeMedia.EXCEL).setUrl(url)).join().getData();
        if (!isInsertedSuccess)
            throw new BusinessException(ErrorCode.INSERT_INTO_MEDIA_FAIL, ErrorCode.INSERT_INTO_MEDIA_FAIL.getMessage());

        return domain + url;
    }

    @Override
    public Boolean create(EvaluationRequest request) {
        Evaluation evaluationValidate = repository.findByDriverIdAndOrderCodeAndEmployeeId(request.getDriverId(), request.getCode(), request.getEmployeeId().toString(), request.getStationId().toString());
        if (evaluationValidate != null)
            throw new BusinessException(ErrorCode.EVALUATION_IS_EXIST, ErrorCode.EVALUATION_IS_EXIST.getMessage());
        Boolean future = managementCaller.findByEmployeeIdAndCodeAndStatus(request.getDriverId(), request.getCode(), request.getEmployeeId()).join().getData();
        if (!future)
            throw new BusinessException(ErrorCode.ORDER_IS_NOT_FOUND, ErrorCode.ORDER_IS_NOT_FOUND.getMessage());
        CompletableFuture<Response<StationResponse>> completableFuture = caller.getStation(request.getStationId());
        DetailEmployeeResponse response = internalService.findById(request.getEmployeeId());
        StationResponse stationResponse = completableFuture.join().getData();
        if (stationResponse == null)
            throw new BusinessException(ErrorCode.GAS_STATION_NOT_FOUND, ErrorCode.GAS_STATION_NOT_FOUND.getMessage());
        Evaluation evaluation = new Evaluation().setEmployee(response).setContent(request.getContent())
                .setOrderCode(request.getCode()).setVote(request.getVote()).setStation(stationResponse)
                .setDriverId(request.getDriverId());
        repository.insert(evaluation);
        return true;
    }

    private Specification<Evaluation> buildPredicates(EvaluationRequestDetail requestDetail) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (requestDetail.getVote() != null)
                predicates.add(criteriaBuilder.equal(root.get("vote"), requestDetail.getVote()));

            if (requestDetail.getEmployeeId() != null) {
                Predicate predicateDriver = criteriaBuilder.equal
                        (criteriaBuilder.function(Global.getFunctionPostgres,
                                String.class, root.get("employee"), criteriaBuilder.literal("employeeId")), requestDetail.getEmployeeId().toString());
                predicates.add(predicateDriver);
            }

            if (requestDetail.getStationId() != null) {
                Predicate predicateDriver = criteriaBuilder.equal
                        (criteriaBuilder.function(Global.getFunctionPostgres,
                                String.class, root.get("station"), criteriaBuilder.literal("id")), requestDetail.getStationId().toString());
                predicates.add(predicateDriver);
            }

            if (requestDetail.getDateFrom() != null && requestDetail.getDateTo() != null) {
                predicates.add(criteriaBuilder.between(root.get("createdAt").as(LocalDate.class), requestDetail.getDateFrom(), requestDetail.getDateTo()));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    public <T> Page<T> createPageFromList(List<T> list, Pageable pageable) {
        int startOfPage = pageable.getPageNumber() * pageable.getPageSize();

        if (startOfPage > list.size() || CollectionUtils.isEmpty(list))
            return new PageImpl<>(new ArrayList<>(), pageable, 0);

        int endOfPage = Math.min(startOfPage + pageable.getPageSize(), list.size());
        return new PageImpl<>(list.subList(startOfPage, endOfPage), pageable, list.size());
    }

    private List<EvaluationResponse> getEvaluationResponse(EvaluationRequestDetail request) {
        List<Evaluation> evaluations = repository.findAll(buildPredicates(request));

        Map<DetailEmployeeResponse, List<Evaluation>> evaluationMap = evaluations.stream().collect(groupingBy(Evaluation::getEmployee));

        List<EvaluationResponse> evaluationResponses = new ArrayList<>();

        evaluationMap.forEach((key, value) -> evaluationResponses.add(mapper.map(key, value)));

        return evaluationResponses.stream().sorted((o1, o2) -> o2.getName().compareTo(o1.getName())).collect(Collectors.toList());
    }

    private Specification<Evaluation> buildPredicates(String accountId, Integer vote) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (accountId != null) {
                Predicate predicateDriver = criteriaBuilder.equal
                        (criteriaBuilder.function(Global.getFunctionPostgres,
                                String.class, root.get("employee"), criteriaBuilder.literal("accountId")), accountId);
                predicates.add(predicateDriver);
            }

            if (vote != null)
                predicates.add(criteriaBuilder.equal(root.get("vote"), vote));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
