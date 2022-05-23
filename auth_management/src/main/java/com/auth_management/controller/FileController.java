package com.auth_management.controller;

import com.auth_management.model.bo.TypeMedia;
import com.auth_management.model.response.FileResponse;
import com.auth_management.model.response.ImageLicensePlatesResponse;
import com.auth_management.model.response.ImageSpeedometerResponse;
import com.auth_management.service.FileService;
import com.auth_management.service.impl.InfoInJwt;
import com.common.model.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(value = "/files")
@Validated
@RequiredArgsConstructor
public class FileController {

    private final FileService service;
    private final InfoInJwt infoInJwt;

    @PostMapping()
    public Response<List<FileResponse>> upload(@RequestParam("files") MultipartFile[] files,
                                               @NotNull @RequestParam("type") TypeMedia type,
                                               @RequestHeader("Authorization") String token) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.upload(files, accountId, type));
    }

    @PostMapping("/speedometer")
    public Response<ImageSpeedometerResponse> uploadSpeedometer(@RequestParam("files") MultipartFile file,
                                                                @Valid @RequestParam("order-id") int orderId,
                                                                @RequestHeader("Authorization") String token) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.uploadSpeedometer(file, accountId, orderId));
    }

    @PostMapping("/license-plates")
    public Response<ImageLicensePlatesResponse> uploadLicensePlates(@RequestParam("files") MultipartFile file,
                                                                    @Valid @RequestParam("order-id") int orderId,
                                                                    @RequestHeader("Authorization") String token) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(service.uploadLicensePlates(file, accountId, orderId));
    }

}
