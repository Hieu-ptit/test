package com.auth_management.caller;

import com.auth_management.model.request.AuthorRequest;
import com.auth_management.model.response.RoleResponseDetail;
import com.auth_management.service.impl.ApiStorage;
import com.auth_management.util.Global;
import com.common.model.response.Response;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
public class PermissionCaller {

    private final RestClient restClient;
    private final ApiStorage apiStorage;

    public CompletableFuture<Response<RoleResponseDetail>> getRoles(String accountId) {
        return restClient.get(apiStorage.getApiRoles(accountId), restClient.headers)
                .thenApply(httpResponse ->
                        Json.decode(httpResponse.body(), Global.roleInfosReader));
    }


    public CompletableFuture<Response<Set<String>>> getActionsByAccountId(String accountId) {
        return restClient.get(apiStorage.getApiGetActionsByAccountId(accountId), restClient.headers)
                .thenApply(httpResponse ->
                        Json.decode(httpResponse.body(), Global.setStringReader));
    }

    public CompletableFuture<Response<Boolean>> authorization(AuthorRequest authorRequest) {
        return restClient.post(authorRequest, Global.authorRequestWriter, apiStorage.getApiAuthorization(), restClient.headers)
                .thenApply(httpResponse ->
                        Json.decode(httpResponse.body(), Global.booleanReader));
    }

}
