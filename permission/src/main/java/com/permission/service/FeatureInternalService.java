package com.permission.service;


import com.permission.model.entity.Feature;

import java.util.List;
import java.util.Set;

public interface FeatureInternalService {

    List<Feature> findAll();

    List<Feature> findAllByIdIn(Set<Integer> featureIds);

}
