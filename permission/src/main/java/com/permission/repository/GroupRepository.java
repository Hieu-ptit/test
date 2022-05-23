package com.permission.repository;

import com.permission.model.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer>, InsertUpdateRepository<Group> {
    List<Group> findByModuleId(int moduleId);
}
