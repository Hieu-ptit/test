package com.admin_management.repository;

import com.admin_management.model.entity.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface EvaluationRepository extends JpaRepository<Evaluation, Integer>, InsertUpdateRepository<Evaluation>, JpaSpecificationExecutor<Evaluation> {

    @Query(value = "select * from evaluations e where driver_id = ?1 and order_code = ?2 and jsonb_extract_path_text(e.employee, 'employeeId') = ?3 and jsonb_extract_path_text(e.station, 'id') = ?4", nativeQuery = true)
    Evaluation findByDriverIdAndOrderCodeAndEmployeeId(String accountId, String orderCode,  String employeeId, String stationId);
}
