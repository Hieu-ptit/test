package com.admin_management.repository;


import com.admin_management.model.entity.Account;
import com.common.model.bo.AccountStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>, InsertUpdateRepository<Account> {

    Optional<Account> findByUsernameAndStatus(String username, AccountStatus status);

    Optional<Account> findByUsernameAndStatusIn(String username, List<AccountStatus> lstStatus);

    Optional<Account> findByIdAndStatus(String id, AccountStatus status);

    Optional<Account> findByIdAndStatusNot(String id, AccountStatus status);

    Optional<Account> findByCode(String id);

    @Query(value = "select * from accounts where status != ?1", nativeQuery = true)
    Page<Account> findByStatusNot(String status, Pageable pageable);

    @Query(value = "select * from accounts " +
            "where (lower(code) like ?1 or lower(username) like ?1 or profile_id in ?2) " +
            "and status != ?3 ", nativeQuery = true)
    Page<Account> findByUsernameOrProfileIdInAndStatusNativeQuery
            (String usernameLike, List<Integer> profileIds, String status, Pageable pageable);

    @Query(value = "select * from accounts " +
            "where (lower(code) like ?1 or lower(username) like ?1 ) " +
            "and status != ?2 ", nativeQuery = true)
    Page<Account> findByUsernameAndStatusNativeQuery(String usernameLike, String status, Pageable pageable);

    @Query(value = "UPDATE accounts SET status = 'DELETE' where id = ?1", nativeQuery = true)
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void deleteAccount(String id);

    boolean existsByUsernameAndStatusNot(String username, AccountStatus status);
}
