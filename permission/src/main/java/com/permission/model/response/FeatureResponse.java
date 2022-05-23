package com.permission.model.response;

import com.permission.model.bo.Method;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class FeatureResponse {

    private Integer id;

    private String name;

    private Method method;

    private boolean checked;

}
