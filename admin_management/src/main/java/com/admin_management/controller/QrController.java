package com.admin_management.controller;

import com.admin_management.model.bo.SortedField;
import com.admin_management.model.request.FilterOtherProduct;
import com.admin_management.service.QrService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/qrs")
@RequiredArgsConstructor
@Validated
public class QrController {

    private final QrService service;

    @GetMapping("/hoses")
    public CompletableFuture<Object> getQrCodesByHose() {
        return service.getQrCodesByHose();
    }

    @GetMapping("/products/others")
    public CompletableFuture<Object> getQrCodeByOtherProduct(@RequestParam(value = "search-text", required = false) String searchedText,
                                                             @RequestParam(value = "field-sort", defaultValue = "createdAt", required = false) SortedField sortedField,
                                                             @RequestParam(value = "direction-sort", defaultValue = "DESC", required = false) Sort.Direction sortedType,
                                                             @RequestParam(value = "page", defaultValue = "1") int page,
                                                             @RequestParam(value = "size", defaultValue = "50") int size) {
        FilterOtherProduct filterOtherProduct = FilterOtherProduct.build()
                .setSearchedText(searchedText)
                .setSortedField(sortedField)
                .setSortedType(sortedType)
                .setPage(page)
                .setSize(size);
        return service.getQrCodeByOtherProduct(filterOtherProduct);
    }
}
