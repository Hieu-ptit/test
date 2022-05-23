package com.admin_management.caller;

import com.admin_management.model.response.StationResponse;
import com.admin_management.service.impl.ApiStorage;
import com.admin_management.util.Global;
import com.common.model.response.Response;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class GasStationCaller {

    private final RestClient restClient;
    private final ApiStorage apiStorage;

    public CompletableFuture<Response<List<StationNameResponse>>> getStationName(Integer employeeId) {
        String url = apiStorage.getStationName(employeeId);
        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.getStationName));
    }

    public CompletableFuture<Response<StationResponse>> getStation(int id) {

        return restClient.get(apiStorage.getStation(id), restClient.headers)
                .thenApply(httpResponse ->
                        Json.decode(httpResponse.body(), Global.stationReader)
                );
    }

}
