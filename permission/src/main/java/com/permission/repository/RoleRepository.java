package com.permission.repository;

import com.permission.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>, InsertUpdateRepository<Role> {

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Integer roleId);

    boolean existsById(int id);

    List<Role> findByIdIn(Set<Integer> ids);

    @Query(value = "select " +
            "* from roles " +
            "where id IN (select a.role_id from role_account a where account_id = ?1)",
            nativeQuery = true)
    List<Role> findByAccountId(String accountId);

    void deleteById(int id);

    List<Role> findByOrderByCreatedAtDesc();

}
