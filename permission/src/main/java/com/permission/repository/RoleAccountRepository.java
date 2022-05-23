package com.permission.repository;

import com.permission.model.entity.RoleAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RoleAccountRepository extends JpaRepository<RoleAccount, Integer>, InsertUpdateRepository<RoleAccount> {

    List<RoleAccount> findByAccountId(String accountId);

    Boolean existsByAccountId(String accountId);

    Boolean existsByRoleId(int roleId);

    @Query(nativeQuery = true, value = "DELETE FROM role_account WHERE account_id = ?1")
    @Modifying
    @Transactional
    void deleteByAccountId(String accountId);
}
