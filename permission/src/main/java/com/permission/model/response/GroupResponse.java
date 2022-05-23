package com.permission.model.response;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class GroupResponse {

    private String id;

    private int moduleId;

    private String name;

    private boolean checked;

    private List<FeatureResponse> features;
}
