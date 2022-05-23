package com.admin_management.service;

import com.admin_management.model.request.FilterOtherProduct;

import java.util.concurrent.CompletableFuture;

public interface QrService {

    /**
     * APi forward for get qr code by hose
     * from public_management
     * @return
     */
    CompletableFuture<Object> getQrCodesByHose();

    /**
     * APi forward for get qr code by other product (not OIL)
     * from ware_house_management
     * @return
     */
    CompletableFuture<Object> getQrCodeByOtherProduct(FilterOtherProduct filterOtherProduct);
}
