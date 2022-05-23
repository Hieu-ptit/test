package com.admin_management.model.response;

import com.admin_management.model.bo.StatusCommon;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Data
@Accessors(chain = true)
public class QrHoseResponse {

    private Integer id;
    private String station;
    private String pole;
    private String hose;
    private BigDecimal price;
    private String nameFuel;
    private String qrCode;
    private QrCodeImage image;
    private StatusCommon status;

}