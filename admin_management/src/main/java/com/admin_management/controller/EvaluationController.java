package com.admin_management.controller;

import com.admin_management.model.request.EvaluationRequest;
import com.admin_management.model.request.EvaluationRequestDetail;
import com.admin_management.model.request.FilterEvaluation;
import com.admin_management.model.response.EvaluationDetail;
import com.admin_management.model.response.EvaluationInfo;
import com.admin_management.service.EvaluationService;
import com.admin_management.service.impl.InfoInJwt;
import com.common.model.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/evaluations")
@Validated
@RequiredArgsConstructor
public class EvaluationController {

    private final EvaluationService service;
    private final InfoInJwt infoInJwt;

    @GetMapping("/filters")
    public Response<EvaluationDetail> filter(
            @RequestParam(value = "employee-id", required = false) Integer employeeId,
            @RequestParam(value = "station-id", required = false) Integer stationId,
            @RequestParam(value = "date-from", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam(value = "date-to", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo,
            @Min(value = 1, message = "4156")
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @Min(value = 0, message = "4157")
            @RequestParam(value = "size", defaultValue = "50") Integer size) {

        EvaluationRequestDetail request = new EvaluationRequestDetail()
                .setStationId(stationId)
                .setEmployeeId(employeeId)
                .setDateFrom(dateFrom)
                .setDateTo(dateTo)
                .setPage(page - 1)
                .setSize(size);
        return Response.ofSucceeded(service.filter(request));
    }

    @GetMapping("/employee/filters")
    public Response<List<EvaluationInfo>> filter(
            @RequestHeader("Authorization") String token,
            @RequestParam(value = "vote", required = false) Integer vote,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @Min(value = 0, message = "4157")
            @RequestParam(value = "size", defaultValue = "50") Integer size) {

        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.findByAccountId(accountId, vote, page - 1, size));
    }

    @GetMapping("/filters/excels")
    public Response<String> exportExcelAllWithFilter(
            @RequestParam(value = "employee-id", required = false) Integer employeeId,
            @RequestParam(value = "station-id", required = false) Integer stationId,
            @RequestParam(value = "date-from", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam(value = "date-to", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo) {

        EvaluationRequestDetail request = new EvaluationRequestDetail()
                .setStationId(stationId)
                .setEmployeeId(employeeId)
                .setDateFrom(dateFrom)
                .setDateTo(dateTo);
        return Response.ofSucceeded(service.exportExcelAllWithFilter(request));
    }

    @GetMapping("/detail")
    public Response<?> getEvaluationDetail(
            @RequestParam(value = "vote", required = false) Integer vote,
            @RequestParam(value = "employee-id", required = false) Integer employeeId,
            @RequestParam(value = "station-id", required = false) Integer stationId,
            @RequestParam(value = "date-from", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam(value = "date-to", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo,
            @Min(value = 1, message = "4156")
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @Min(value = 0, message = "4157")
            @RequestParam(value = "size", defaultValue = "50") Integer size) {
        EvaluationRequestDetail evaluation = new EvaluationRequestDetail()
                .setVote(vote)
                .setDateFrom(dateFrom)
                .setDateTo(dateTo)
                .setEmployeeId(employeeId)
                .setStationId(stationId)
                .setPage(page - 1)
                .setSize(size);
        return Response.ofSucceeded(service.getEvaluationDetail(evaluation));
    }

    @GetMapping("/export/excels")
    public Response<?> exportExcelsDetail(
            @RequestParam(value = "vote", required = false) Integer vote,
            @RequestParam(value = "employee-id", required = false) Integer employeeId,
            @RequestParam(value = "station-id", required = false) Integer stationId,
            @RequestParam(value = "date-from", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam(value = "date-to", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo,
            @Min(value = 1, message = "4156")
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @Min(value = 0, message = "4157")
            @RequestParam(value = "size", defaultValue = "50") Integer size) throws IOException, IllegalAccessException {
        EvaluationRequestDetail evaluation = new EvaluationRequestDetail()
                .setVote(vote)
                .setDateFrom(dateFrom)
                .setDateTo(dateTo)
                .setEmployeeId(employeeId)
                .setStationId(stationId)
                .setPage(page - 1)
                .setSize(size);
        return Response.ofSucceeded(service.exportExcelsDetail(evaluation));
    }

    @PostMapping("/internal")
    public Response<Boolean> create(@Valid @RequestBody EvaluationRequest request) {
        return Response.ofSucceeded(service.create(request));
    }
}
