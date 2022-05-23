package com.admin_management.service.impl;

import com.admin_management.caller.RestClient;
import com.admin_management.model.request.FilterOtherProduct;
import com.admin_management.service.QrService;
import com.admin_management.util.Global;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class QrServiceImpl implements QrService {

    private final RestClient restClient;
    private final ApiStorage apiStorage;

    /**
     * APi forward for get qr code by hose
     * from public_management
     * @return Object
     */
    @Override
    public CompletableFuture<Object> getQrCodesByHose() {
        return restClient.get(apiStorage.getQrCodesByHose(), new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.qrCodeReader));
    }

    /**
     * APi forward for get qr code by other product (not OIL)
     * from ware_house_management
     * @return Object
     */
    @Override
    public CompletableFuture<Object> getQrCodeByOtherProduct(FilterOtherProduct filterOtherProduct) {
        return restClient.get(apiStorage.getQrCodeByOtherProduct(filterOtherProduct), new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.qrCodeReader));
    }
}
