package com.permission.model.request;

import com.permission.model.bo.Method;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
public class AuthorRequest {

    @NotBlank
    private String path;

    @NotNull
    private Method method;

    @NotNull
    private Map<Integer, @NotNull Map<String, @NotNull Integer>> bitSetModule;

}
