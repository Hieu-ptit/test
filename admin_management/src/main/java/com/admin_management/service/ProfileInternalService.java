package com.admin_management.service;

import com.admin_management.model.entity.Employees;
import com.admin_management.model.entity.Profile;

import java.util.List;
import java.util.Set;

public interface ProfileInternalService {

    List<Profile> findByIdIn(Set<Integer> ids);

    List<Profile> findByNameLike(String searchText);

    Profile findById(Integer id);

    Profile update(Integer id , Employees employees);
}
