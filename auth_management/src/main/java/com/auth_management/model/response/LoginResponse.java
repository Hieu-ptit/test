package com.auth_management.model.response;

import com.dslplatform.json.CompiledJson;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@CompiledJson
@Data
@Accessors(chain = true)
public class LoginResponse {

    private AccountAuth accountAuth;

    private String token;

    private boolean changePassword;

    private Set<String> actions;

    public LoginResponse() {
    }

    public LoginResponse(AccountAuth accountAuth, String token, Set<String> actions) {
        this.accountAuth = accountAuth;
        this.token = token;
        this.actions = actions;
    }

    public LoginResponse(AccountAuth accountAuth, boolean changePassword) {
        this.accountAuth = accountAuth;
        this.changePassword = changePassword;
    }

}
