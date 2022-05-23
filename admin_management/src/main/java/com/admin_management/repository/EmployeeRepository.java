package com.admin_management.repository;

import com.admin_management.model.bo.EmployeeStatus;
import com.admin_management.model.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer>, InsertUpdateRepository<Employees>, JpaSpecificationExecutor<Employees> {

    Employees findByAccountId(String accountId);

    @Query(value = "select * from employees where (lower (name) like ?1 or lower (code) like ?1 " +
            "or lower(jsonb_extract_path_text(department, 'name')) like ?1 " +
            "or lower(jsonb_extract_path_text(positions, 'name')) like ?1 )", nativeQuery = true)
    List<Employees> findEmployeeBySearchText(String searchText);

    boolean existsByPhoneAndStatusNot(String phone, EmployeeStatus status);

    boolean existsByIdentityCardNumberAndStatusNot(String number, EmployeeStatus status);

    List<Employees> findByIdIn(List<Integer> ids);

    @Query(value = "UPDATE employees  SET status = 'DELETE' WHERE id = ?1", nativeQuery = true)
    @Modifying
    @Transactional(rollbackFor = Exception.class)
    void deleteEmployees(Integer id);

    List<Employees> findByStatusAndAccountIdOrderByCreatedAtDesc(EmployeeStatus status, String accountId);

    List<Employees> findByAccountIdIn(List<String> ids);

    List<Employees> findByIdInAndStatus(List<Integer> ids, EmployeeStatus status);

    @Query(value = "select account_id from employees where id in ?1", nativeQuery = true)
    List<String> findAccountIdByEmployee(List<Integer> ids);

    Optional<Employees> findByIdAndStatus(Integer id, EmployeeStatus status);

    @Query(value = "SELECT * FROM employees e WHERE jsonb_extract_path_text(e.department, 'code') = 'DVT' and e.status = 'ACTIVE'", nativeQuery = true)
    List<Employees> findByDepartmentShippingTeam();
}
