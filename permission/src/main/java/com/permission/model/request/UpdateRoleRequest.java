package com.permission.model.request;

import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

@Data
@Accessors(chain = true)
public class UpdateRoleRequest {

    @NotBlank(message = "4133")
    @Length(max = 100, message = "4134")
    private String name;

    @Length(max = 200, message = "4135")
    private String description;

    /**
     * Module contain groups, a group contain features
     * ex: {"module_id_1":{"PRODUCT_TYPE":[1,2],"PRODUCT":[3,6]},"module_id_2":{"DRIVER":[5,7]}}
     * <p>
     * key: group code
     * value: feature id list
     */
    @NotNull(message = "4199")
    private Map<String, Set<@NotNull(message = "4200") Integer>> groupFeature;

    public String getName() {
        return StringUtils.isBlank(name) ? null : name.trim();
    }

    public String getDescription() {
        return StringUtils.isBlank(description) ? null : description.trim();
    }

}
