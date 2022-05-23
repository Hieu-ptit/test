package com.auth_management.model.bo;

import com.common.model.API;

import javax.servlet.http.HttpServletRequest;

public class ApisSkipperAuthorization {

    public ApisSkipperAuthorization() {
    }

    public static final API[] skipAuthAPIs = new API[]{
            API.with("^/management/provinces$"),
            API.with("^/management/wards$"),
            API.with("^/management/wards/(.*)"),
            API.with("^/management/districts$"),
            API.with("^/management/properties$"),
            API.with("^/management/properties/contracts-type$"),
            API.with("^/management/properties/department$"),
            API.with("^/management/properties/department-type$"),
            API.with("^/management/payments/methods/actively$"),
            API.with("^/management/gas-stations/station-employee$"),
            API.with("^/management/gas-stations/station$"),
            API.with("^/management/swap-shifts$"),
            API.with("^/management/import-request/filters$"),
            API.with("^/management/shifts-off-time$"),
            API.with("^/management/calendars$"),
            API.with("^/management/shifts-off-time$"),
            API.with("^/management/orders/shift-order$"),
            API.with("^/management/lock-shifts/order-shift$"),
            API.with("^/management/product-revenue$"),
            API.with("^/notifications/(.*)$"),
            API.with("^/management/shifts/days$"),
            API.with("^/management/calendars/employees/infos$"),
            API.with("^/management/products/other/(.*)$"),
            API.with("^/management/profiles/avatar$"),
            API.with("^/management/products/category/(.*)"),
            API.with("^/management/employees/station-status$"),
            API.with("^/management/suppliers(.*)$"),
            API.with("^/management/transit-cars(.*)$"),
            API.with("^/management/employees/shipping-team$"),
            API.with("^/management/gas-stations/corporation$"),
            API.with("^/management/suppliers/stations$"),
            API.with("^/management/tracking-price$"),
            API.with("^/management/employees/stations-employee$"),
            API.with("^/management/shallows/infos$"),
            API.with("^/management/accounts/passwords/changers$"),
            API.with("^/management/products/products-oils$"),
            API.with("^/management/news/details/(.*)$"),
            API.with("^/management/ranks/highers$"),
            API.with("^/management/accounts/toggles/otps$"),
            API.with("^/management/swap-shifts/employees$"),
            API.with("^/management/news$"),
            API.with("^/management/banners$"),
            API.with("^/management/swap-shifts/employees$"),
            API.with("^/management/accounts/infos$"),
            API.with("^/management/orders/(.*)$"),
            API.with("^/management/orders/actuality-pay/(.*)$"),
            API.with("^/management/orders/confirmed-pay$"),
            API.with("^/management/calendars/employees/details$"),
            API.with("^/management/shifts/dates$"),
            API.with("^/management/calendars/employees/shift$"),
            API.with("^/management/gas-stations/station$"),
            API.with("^/management/calendars/employees/stations$"),
            API.with("^/management/auth/logout$"),
            API.with("^/management/profiles$"),
            API.with("^/management/profiles/avatar$"),
            API.with("^/management/accounts/passwords/changers$"),
            API.with("^/management/files/license-plates$"),
            API.with("^/management/files/speedometer$"),
            API.with("^/management/warehouse-export/word/(.*)$"),
            API.with("^/management/payment-order/(.*)$"),
            API.with("^/management/warehouse-import/word/(.*)$"),
            API.with("^/management/measures/export/word$"),
            API.with("^/management/shallows/export/word/(.*)$"),
            API.with("^/management/news/shows$"),
            API.with("^/management/accounts/authentication/otps$"),
            API.with("^/management/evaluations/filters/excels$"),
            API.with("^/management/evaluations/export/excels$"),
            API.with("^/management/import-request/import-product/(.*)"),
            API.with("^/management/import-request/confirm-swap/(.*)")
    };

    public static final API[] packageExpireAPIs = new API[]{
            API.with("^/projects$"),
    };

    public static boolean isSkipAuthAPI(HttpServletRequest request) {
        for (API skipAuthAPI : ApisSkipperAuthorization.skipAuthAPIs) {
            if (skipAuthAPI.isSkipRequest(request)) {
                return true;
            }
        }
        return false;
    }

}
