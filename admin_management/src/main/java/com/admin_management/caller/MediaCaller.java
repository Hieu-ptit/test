package com.admin_management.caller;

import com.admin_management.model.request.MediaRequest;
import com.admin_management.service.impl.ApiStorage;
import com.admin_management.util.Global;
import com.common.model.response.Response;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class MediaCaller {

    private final RestClient restClient;
    private final ApiStorage apiStorage;

    public CompletableFuture<Response<Boolean>> insertIntoMedia(MediaRequest mediaRequest) {
        return restClient.post(mediaRequest, Global.mediaRequestWriter, apiStorage.insertIntoMedia(), restClient.headers)
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.booleanReader));
    }
}
