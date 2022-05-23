package com.auth_management.service;

import com.auth_management.model.bo.TypeMedia;
import com.auth_management.model.response.FileResponse;
import com.auth_management.model.response.ImageLicensePlatesResponse;
import com.auth_management.model.response.ImageSpeedometerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    List<FileResponse> upload(MultipartFile[] files, String accountId, TypeMedia type);

    ImageSpeedometerResponse uploadSpeedometer(MultipartFile file, String accountId, int orderId);

    ImageLicensePlatesResponse uploadLicensePlates(MultipartFile file, String accountId, int orderId);

}
