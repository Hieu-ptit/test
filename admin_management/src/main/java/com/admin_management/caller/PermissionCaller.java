package com.admin_management.caller;

import com.admin_management.model.request.CreateRolesAccountRequest;
import com.admin_management.model.request.UpdateRolesAccountRequest;
import com.admin_management.model.request.ValidateRolesRequest;
import com.admin_management.model.response.RoleResponseDetail;
import com.admin_management.service.impl.ApiStorage;
import com.admin_management.util.Global;
import com.common.model.response.Response;
import com.common.util.Json;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

@Component
@RequiredArgsConstructor
public class PermissionCaller {

    private final RestClient restClient;
    private final ApiStorage apiStorage;

    /**
     * validate roleIds  on permission service
     * <p>
     * @param roleIds roleIds
     *
     * @return boolean
     */
    public boolean validateGroup(Set<Integer> roleIds) {

        ValidateRolesRequest validateRolesRequest = new ValidateRolesRequest();
        validateRolesRequest.setRoleIds(roleIds);
        String url = apiStorage.getApiCheckPermission();
        try {
            return restClient.post(validateRolesRequest,
                    Global.validateRolesWriter,
                    url,
                    restClient.headers).join().statusCode() == 200;
        } catch (CompletionException ignored) {
            return false;
        }
    }

    /**
     * save role account
     * <p>
     * @param roleIds roleIds
     * @param accountId accountId
     *
     * @return boolean
     */
    public boolean saveRolesAccount(Set<Integer> roleIds, String accountId) {
        CreateRolesAccountRequest createRolesAccountRequest = new CreateRolesAccountRequest();
        createRolesAccountRequest.setAccountId(accountId);
        createRolesAccountRequest.setRoleIds(roleIds);
        String url = apiStorage.getApiInsertUpdateRolesAccount();
        try {
            return restClient.post(createRolesAccountRequest,
                    Global.createRolesAccountWriter,
                    url,
                    restClient.headers).join().statusCode() == 200;
        } catch (CompletionException e) {
            return false;
        }
    }

    /**
     * delete account role by account id
     *
     * @param accountId accountId
     * @return boolean
     */
    public boolean updateRolesAccount(Set<Integer> roleIds, String accountId) {
        UpdateRolesAccountRequest updateRolesAccountRequest = new UpdateRolesAccountRequest().setAccountId(accountId)
                .setRoleIds(roleIds);
        String url = apiStorage.getApiInsertUpdateRolesAccount();
        try {
            return restClient.put(updateRolesAccountRequest,
                    Global.updateRolesAccountWriter,
                    url,
                    restClient.headers).join().statusCode() == 200;
        } catch (CompletionException e) {
            return false;
        }
    }

    /**
     * get all role by id account
     *
     * @return CompletableFuture<Response < RoleResponseDetail>>
     */
    public CompletableFuture<Response<RoleResponseDetail>> getRoleByAccountId(String accountId) {
        return restClient.get(apiStorage.getRoleByAccountId(accountId), new HashMap<>())
                .thenApply(httpResponse -> Json.decode(httpResponse.body(), Global.proleResponseDetailReader));
    }
}
