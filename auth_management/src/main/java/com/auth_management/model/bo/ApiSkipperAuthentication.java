package com.auth_management.model.bo;

import com.common.model.API;

import javax.servlet.http.HttpServletRequest;

public class ApiSkipperAuthentication {

    public ApiSkipperAuthentication() {
    }

    public static final API[] skipAuthAPIs = new API[]{
            API.with("^/drivers/accounts/login$"),
            API.with("^/drivers/profiles$"),
            API.with("^/test$"),
            API.with("^/accounts/register$"),
            API.with("^/files/images$"),
            API.with("^/error$"),
            API.with("^/v2/api-docs(.*)$"),
            API.with("^(.*)swagger(.*)$"),
            API.with("^/files(.*)$"),
            API.with("^/$"),
            API.with("^/management/accounts/login$"),
            API.with("^/management/accounts/passwords/first$"),
            API.with("^/management/profiles$"),
            API.with("^/management/device-tokens$"),
            API.with("^/management/area-products"),
            API.with("^/management/employees/station-status"),
            API.with("^/management/calendars/employees(.*)$"),
            API.with("^/management/calendars/employees/details(.*)$"),
            API.with("^/management/shifts/dates(.*)$"),
            API.with("^/management/calendars/employees/shift(.*)$"),
            API.with("^/management/gas-stations/station(.*)$"),
            API.with("^/management/calendars/employees/stations(.*)$"),
            API.with("^/management/suppliers/stations/import-export(.*)$"),
            API.with("^/management/gas-stations/employee-active(.*)$"),
            API.with("^/management/gas-stations/employee/station-active(.*)$"),
            API.with("^/management/banners/shows(.*)$"),
            API.with("^/management/measures/infos(.*)$"),
            API.with("^/management/gas-stations/employee/status-corporation(.*)$"),
            API.with("^/management/gas-stations/status-corporation(.*)$"),
            API.with("^/management/evaluations/employee/filters(.*)$"),
            API.with("^/management/gas-stations(.*)$"),
            API.with("^/permissions/groups/log$"),
            API.with("^/management/warehouse-orders/driver(.*)$"),
            API.with("^/management/gas-fields/station(.*)$"),
            API.with("^/drivers/accounts/otp$"),
            API.with("^/drivers/accounts/register$")


    };

    public static final API[] packageExpireAPIs = new API[]{
            API.with("^/projects$"),
    };

    public static boolean isSkipAuthAPI(HttpServletRequest request) {
        for (API skipAuthAPI : ApiSkipperAuthentication.skipAuthAPIs) {
            if (skipAuthAPI.isSkipRequest(request)) {
                return true;
            }
        }
        return false;
    }


}
