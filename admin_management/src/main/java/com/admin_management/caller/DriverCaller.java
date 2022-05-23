package com.admin_management.caller;

import com.admin_management.service.impl.ApiStorage;
import com.admin_management.util.Global;
import com.common.model.response.Response;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class DriverCaller {

    private final RestClient restClient;
    private final ApiStorage apiStorage;

    /**
     * call api check  account driver exist
     *
     * @param id id
     * @return CompletableFuture<Response<Boolean>>
     */
    public CompletableFuture<Response<Boolean>> checkDriverExist(String id) {

        String url = apiStorage.checkDriverExist(id);

        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.checkDriver));
    }

    /**
     * Delete account Driver
     *
     * @param id id
     * @return CompletableFuture<Response<Boolean>>
     */
    public CompletableFuture<Response<Boolean>> deleteDriver(String id) {

        String url = apiStorage.deleteDriver(id);

        return restClient.get(url, new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.deleteDriver));
    }

}
