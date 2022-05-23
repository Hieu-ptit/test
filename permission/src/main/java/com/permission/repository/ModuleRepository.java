package com.permission.repository;

import com.permission.model.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer>, InsertUpdateRepository<Module> {
}
