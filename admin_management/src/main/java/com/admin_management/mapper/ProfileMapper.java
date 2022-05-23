package com.admin_management.mapper;

import com.admin_management.model.entity.Account;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.entity.Profile;
import com.admin_management.model.response.ProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileMapper {

    public Profile map(Profile profile, Employees employees) {
        return profile.setName(employees.getName())
                .setPhone(employees.getPhone())
                .setAddress(employees.getAddress());

    }

    public ProfileResponse map(Profile profile, Account account, Employees employees, Boolean checkApp) {
        ProfileResponse profileResponse = new ProfileResponse();

        profileResponse.setId(profile.getId());
        profileResponse.setAccountId(account.getId());
        profileResponse.setName(profile.getName());
        profileResponse.setIdCard(employees.getIdentityCardNumber());
        profileResponse.setDateOfBirth(employees.getDateOfBirth());
        profileResponse.setLocation(employees.getFullAddress());
        profileResponse.setEmail(employees.getEmail());
        profileResponse.setCode(employees.getCode());
        profileResponse.setPhone(employees.getPhone());

        if (checkApp) profileResponse.setAvatar(profile.getAvatar());
        else profileResponse.setAvatar(employees.getAvatar());

        return profileResponse;
    }
}
