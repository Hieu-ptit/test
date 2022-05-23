package com.admin_management.service;

import com.admin_management.model.entity.Employees;
import com.admin_management.model.response.DetailEmployeeResponse;

import java.util.List;

public interface EmployeeInternalService {

    Employees findByEmployeeById(Integer id);

    DetailEmployeeResponse findById(Integer id);

    Employees findByIdAccount(String id);

    void updateAccountId(Employees employees);

    List<Employees> findByAccountIdIn(List<String> ids);

    List<String> findAccountIdsByEmployeeIds(List<Integer> ids);
}
