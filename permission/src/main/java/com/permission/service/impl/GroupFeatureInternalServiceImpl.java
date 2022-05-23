package com.permission.service.impl;

import com.permission.model.entity.GroupFeature;
import com.permission.repository.GroupFeatureRepository;
import com.permission.service.GroupFeatureInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class GroupFeatureInternalServiceImpl implements GroupFeatureInternalService {

    private final GroupFeatureRepository repository;

    /**
     * get all GroupFeature
     *
     * @return List<GroupFeature>
     */
    public List<GroupFeature> findAll() {
        return repository.findAll();
    }

    /**
     * get all GroupFeature by set id
     *
     * @param groupIds groupIds
     * @return List<GroupFeature>
     */
    public List<GroupFeature> findAllByIdGroupIn(Set<String> groupIds) {
        return repository.findByGroupIdIn(groupIds);
    }

}
