package com.permission.repository;

import com.permission.model.entity.RoleGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Integer>, InsertUpdateRepository<RoleGroup> {

    @Query(value = "DELETE FROM role_group r WHERE r.roleId =?1")
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    void deleteAllByRoleId(int roleId);
}
