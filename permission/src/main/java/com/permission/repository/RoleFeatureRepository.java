package com.permission.repository;

import com.permission.model.entity.RoleFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleFeatureRepository extends JpaRepository<RoleFeature, Integer>, InsertUpdateRepository<RoleFeature> {

    @Query(value = "select * " +
            "from role_feature " +
            "where role_id = ?1",
            nativeQuery = true)
    List<RoleFeature> findByRoleId(int roleId);

    List<RoleFeature> findByRoleIdIn(Set<Integer> roleIds)
;
    @Query(value = "DELETE FROM role_feature r WHERE r.roleId=?1")
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    void deleteAllByRoleId(int roleId);
}
