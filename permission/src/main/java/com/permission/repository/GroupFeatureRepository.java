package com.permission.repository;

import com.permission.model.entity.GroupFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GroupFeatureRepository extends JpaRepository<GroupFeature, Integer> {

    List<GroupFeature> findByGroupIdIn(Set<String> groupIds);
}
