package com.permission.service.impl;

import com.permission.model.entity.Feature;
import com.permission.repository.FeatureRepository;
import com.permission.service.FeatureInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FeatureInternalServiceImpl implements FeatureInternalService {

    private final FeatureRepository repository;

    /**
     * get all feature
     *
     * @return List<Feature>
     */
    @Override
    public List<Feature> findAll() {
        return repository.findAll();
    }

    /**
     * get all feature by set id
     *
     * @param featureIds featureIds
     * @return List<Feature>
     */
    @Override
    public List<Feature> findAllByIdIn(Set<Integer> featureIds) {
        return repository.findByIdIn(featureIds);
    }
}
