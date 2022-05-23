package com.auth_management.service.impl;

import com.auth_management.caller.RestClient;
import com.auth_management.model.bo.TypeMedia;
import com.auth_management.model.request.CreateFile;
import com.auth_management.model.request.FileRequest;
import com.auth_management.model.request.ImageLicensePlatesRequest;
import com.auth_management.model.request.ImageSpeedometerRequest;
import com.auth_management.model.response.*;
import com.auth_management.service.FileService;
import com.auth_management.util.Global;
import com.common.exception.BusinessException;
import com.common.util.Constant;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final ApiStorage apiStorage;

    private final RestClient restClient;

    @Value("${app.server.upload.domain}")
    private String domain;

    @Value("${app.server.upload.folder.path}")
    private String uploadDir;

    private final Logger logger = LogManager.getLogger(getClass());

    /**
     * upload file
     *
     * @param
     * @return
     */
    @Override
    public List<FileResponse> upload(MultipartFile[] files, String accountId, TypeMedia type) {
        if (files.length > 10)
            throw new BusinessException(ErrorCode.ONLY_UPLOAD_10_FILES, ErrorMessage.ONLY_UPLOAD_10_FILES);

        List<FileRequest> fileRequests = new ArrayList<>();

        Arrays.stream(files).forEach(file -> {
            String fileName = getFileName(file);
            try {
                saveFile(uploadDir, fileName, file);
                fileRequests.add(new FileRequest().setOwner(accountId)
                        .setUrl(createImageSource(fileName).toString())
                        .setTypeMedia(type)
                        .setName(file.getOriginalFilename()));
            } catch (IOException e) {
                logger.error(FileService.class, e);
            }
        });

        return createMedia(new CreateFile().setFilesRequest(fileRequests)).getFileResponses();
    }

    /**
     * upload image speedometer
     *
     * @param file
     * @param accountId
     * @param orderId
     * @return
     */
    @Override
    public ImageSpeedometerResponse uploadSpeedometer(MultipartFile file, String accountId, int orderId) {
        String fileName = getFileName(file);
        try {
            saveFile(uploadDir, fileName, file);
        } catch (IOException e) {
            logger.error(FileService.class, e);
        }
        return createImageSpeedometer(new ImageSpeedometerRequest().setName(fileName)
                .setOrderId(orderId).setSpeedometer(123456)
                .setName(fileName)
                .setUrl(createImageSource(fileName).toString())
                .setAccountId(accountId));
    }

    /**
     * update image license plates
     *
     * @param file
     * @param accountId
     * @param orderId
     * @return
     */
    @Override
    public ImageLicensePlatesResponse uploadLicensePlates(MultipartFile file, String accountId, int orderId) {
        String fileName = getFileName(file);
        try {
            saveFile(uploadDir, fileName, file);
        } catch (IOException e) {
            logger.error(FileService.class, e);
        }
        return createImageLicensePlate(new ImageLicensePlatesRequest().setOrderId(orderId)
                .setUrl(createImageSource(fileName).toString())
                .setName(fileName)
                .setDate(LocalDate.now().toString())
                .setAccountId(accountId));
    }

    private MediaResponse createMedia(CreateFile createFile) {
        String url = apiStorage.getApiUpFile();
        return restClient.postNHandleError
                (createFile, Global.fileWriter, Global.fileReader, url, restClient.headers).join().getData();
    }

    private ImageSpeedometerResponse createImageSpeedometer(ImageSpeedometerRequest request) {
        String url = apiStorage.getApiCreateImageSpeedometer();
        return restClient.postNHandleError
                (request, Global.fileImageSpeedometerWriter, Global.fileImageSpeedometerReader, url, restClient.headers).join().getData();
    }

    private ImageLicensePlatesResponse createImageLicensePlate(ImageLicensePlatesRequest request) {
        String url = apiStorage.getApiCreateImageLicensePlate();
        return restClient.postNHandleError
                (request, Global.fileImagePlateWriter, Global.fileImagePlateReader, url, restClient.headers).join().getData();
    }

    /**
     * @param fileName
     * @return
     */
    private String modifyFileName(String fileName) {
        return Constant.generateUUID() + Constant.SEPARATOR + fileName.replaceAll("\\s+", " ").replace(' ', '-');
    }

    /**
     * @param uploadDir
     * @param fileName
     * @param multipartFile
     * @throws IOException
     */
    private void saveFile(String uploadDir, String fileName,
                          MultipartFile multipartFile) throws IOException {
        LocalDate folderName = LocalDate.now();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        Path uploadPathFolder = Paths.get(uploadDir + "/" + folderName);

        if (!Files.exists(uploadPathFolder)) {
            Files.createDirectories(uploadPathFolder);
        }

        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPathFolder.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Could not save image file: " + fileName, e);
        }
    }

    /**
     * @param fileName
     * @return
     */
    private StringBuilder createImageSource(String fileName) {
        return new StringBuilder("/images/").append(LocalDate.now()).append("/")
                .append(fileName);
    }

    private String getFileName(MultipartFile file) {
        return modifyFileName(Objects.requireNonNull(file.getOriginalFilename()));
    }

}
