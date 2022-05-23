package com.admin_management.model.bo;

import com.admin_management.model.entity.Account;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.entity.Profile;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@Accessors(chain = true)
public class FindAccountInfo {

    private Page<Account> accounts;

    private List<Profile> profiles;

    private List<Employees> employees;

    public boolean hasProfiles() {
        return CollectionUtils.isEmpty(this.profiles);
    }

    /**
     * Convert List Profile to Map
     * key: id : integer
     * value: profile: Profile
     *
     * @return
     */
    public Map<Integer, Profile> toMapIdNProfile() {
        if (hasProfiles())
            return new HashMap<>();

        return this.profiles.stream().collect(Collectors.toMap(Profile::getId, it -> it));
    }

    public boolean hasEmployees() {
        return CollectionUtils.isEmpty(this.employees);
    }

    /**
     * Convert List Profile to Map
     * key: id : integer
     * value: profile: Profile
     *
     * @return
     */
    public Map<String, Employees> toMapIdNEmployees() {
        if (hasEmployees())
            return new HashMap<>();

        return this.employees.stream().collect(Collectors.toMap(Employees::getAccountId, it -> it));
    }

}
