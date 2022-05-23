package com.permission.service.impl;

import com.permission.model.entity.Group;
import com.permission.repository.GroupRepository;
import com.permission.service.GroupInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupInternalServiceImpl implements GroupInternalService {

    private final GroupRepository repository;

    /**
     * get all group
     *
     * @return List<Group>
     */
    @Override
    public List<Group> findAll() {
        return repository.findAll();
    }

}



