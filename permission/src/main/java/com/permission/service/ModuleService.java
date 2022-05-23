package com.permission.service;

import com.permission.model.response.ModuleResponse;

import java.util.List;

public interface ModuleService {

    List<ModuleResponse> getAll();

    List<ModuleResponse> getByRoleId(int roleId);

}
