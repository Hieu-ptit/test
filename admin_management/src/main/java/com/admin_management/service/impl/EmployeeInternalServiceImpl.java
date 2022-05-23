package com.admin_management.service.impl;

import com.admin_management.mapper.EmployeeMapper;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.response.DetailEmployeeResponse;
import com.admin_management.repository.EmployeeRepository;
import com.admin_management.service.EmployeeInternalService;
import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeInternalServiceImpl implements EmployeeInternalService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    /**
     * find employee by id
     *
     * param id
     * @return Employees
     */
    public Employees findByEmployeeById(Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.EMPLOYEE_NOT_EXIST,
                        String.format(ErrorMessage.EMPLOYEE_NOT_EXIST, id)));

    }

    @Override
    public DetailEmployeeResponse findById(Integer id){
        Employees employees = repository.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.EMPLOYEE_NOT_EXIST,
                        String.format(ErrorMessage.EMPLOYEE_NOT_EXIST, id)));
        return mapper.mapToDetail(employees);
    }

    @Override
    public Employees findByIdAccount(String id) {
        return repository.findByAccountId(id);
    }

    @Override
    public void updateAccountId(Employees employees) {
        repository.update(employees);
    }

    @Override
    public List<Employees> findByAccountIdIn(List<String> ids) {
        return repository.findByAccountIdIn(ids);
    }

    @Override
    public List<String> findAccountIdsByEmployeeIds(List<Integer> ids) {
        return repository.findAccountIdByEmployee(ids);
    }
}

