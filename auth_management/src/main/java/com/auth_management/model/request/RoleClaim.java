package com.auth_management.model.request;

import com.common.util.Json;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.Map;
import java.util.Set;

@Data
public class RoleClaim {

    private String role;

    private String bitSet;

    public RoleClaim setRole(Set<Integer> roleIds) {
        if (CollectionUtils.isEmpty(roleIds)) {
            this.role = "";
            return this;
        }

        this.role = Json.encodeToString(roleIds);
        return this;
    }

    public RoleClaim setBitSet(Map<Integer, Map<String, Integer>> bitSetSummary) {
        if (CollectionUtils.isEmpty(bitSetSummary)) {
            this.bitSet = "";
            return this;
        }

        this.bitSet = Json.encodeToString(bitSetSummary);
        return this;
    }

    public static RoleClaim build() {
        return new RoleClaim();
    }

}
