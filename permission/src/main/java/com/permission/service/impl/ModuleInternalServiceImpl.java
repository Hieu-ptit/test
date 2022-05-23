package com.permission.service.impl;

import com.permission.repository.ModuleRepository;
import com.permission.service.ModuleInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModuleInternalServiceImpl implements ModuleInternalService {
    private final ModuleRepository repository;

    @Override
    public boolean doesModuleExist(int moduleId) {
        return repository.existsById(moduleId);
    }

}

