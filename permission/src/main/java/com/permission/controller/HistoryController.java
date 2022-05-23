package com.permission.controller;

import com.common.model.response.Response;
import com.permission.model.request.HistoryRequest;
import com.permission.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/histories")
@RequiredArgsConstructor
public class HistoryController {

    public final HistoryService historyService;

    @PostMapping()
    public Response<Boolean> create(@Valid @RequestBody HistoryRequest request) {

        return Response.ofSucceeded(historyService.create(request));
    }
}
