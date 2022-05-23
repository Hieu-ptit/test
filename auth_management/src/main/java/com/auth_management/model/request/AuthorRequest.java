package com.auth_management.model.request;

import com.auth_management.model.bo.Method;
import com.auth_management.util.Global;
import com.common.util.Json;
import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@CompiledJson
public class AuthorRequest {

    private String path;

    private Method method;

    @JsonAttribute(name = "bit_set_module")
    private Map<Integer, Map<String, Integer>> bitSetModule;

    public static AuthorRequest build() {
        return new AuthorRequest();
    }

    public AuthorRequest setBitSetModule(String bitSet) {
        this.bitSetModule = Json.decode(bitSet.getBytes(StandardCharsets.UTF_8), Global.bitSetReader);
        return this;
    }

    public AuthorRequest setBitSetModule(Map<Integer, Map<String, Integer>> bitSetModule) {
        this.bitSetModule = bitSetModule;
        return this;
    }

    public Map<Integer, Map<String, Integer>> getBitSetModule() {
        return this.bitSetModule;
    }

    public String getPath() {
        return path;
    }

    public AuthorRequest setPath(String path) {
        this.path = path;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public AuthorRequest setMethod(Method method) {
        this.method = method;
        return this;
    }
}
