package com.auth_management.service.impl;

import com.common.model.ApiList;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApiStorage {

    private final Logger logger = LogManager.getLogger(getClass());

    @Value("${app.base.url.management.public}")
    public String urlPublicManagement;

    @Value("${app.base.url.management.permission}")
    public String urlPermissionManagement;

    @Value("${app.base.url.integrate.ai}")
    public String urlIntegrateAI;

    /**
     * Get Api get profile qr
     * @returncode
     */
    public String getApiUpFile() {
        String url = urlPublicManagement +  ApiList.API_UPLOAD_FILE;
        logger.info("Call to url : " + url);
        return url;
    }

    public String getApiCreateImageSpeedometer() {
        String url = urlPublicManagement +  ApiList.API_UPLOAD_IMAGE_SPEEDOMETER;
        logger.info("Call to url : " + url);
        return url;
    }

    public String getApiCreateImageLicensePlate() {
        String url = urlPublicManagement +  ApiList.API_UPLOAD_IMAGE_LICENSE_PLATE;
        logger.info("Call to url : " + url);
        return url;
    }

    public String getApiRoles(String accountId) {
        String url = urlPermissionManagement + String.format(ApiList.API_GET_ROLES, accountId);
        logger.info("Call to url : " + url);
        return url;
    }

    public String getApiGetActionsByAccountId(String accountId) {
        String url = urlPermissionManagement + String.format(ApiList.API_GET_ACTIONS, accountId);
        logger.info("Call to url : " + url);
        return url;
    }

    public String getApiAuthorization() {
        String url = urlPermissionManagement + ApiList.API_AUTHORIZATION;
        logger.info("Call to url : " + url);
        return url;
    }

}
