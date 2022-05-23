package com.admin_management.model.entity;

import com.admin_management.converter.JsonConverterEmployee;
import com.admin_management.converter.JsonConverterStation;
import com.admin_management.model.response.DetailEmployeeResponse;
import com.admin_management.model.response.StationResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "evaluations")
@Table(indexes = {

})
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Evaluation extends BaseEntity {

    @Id
    @SequenceGenerator(name = "evaluation_id_seq", sequenceName = "evaluation_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "evaluation_id_seq")
    Integer id;

    @Column(columnDefinition = "varchar(64)")
    String driverId;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterEmployee.class)
    DetailEmployeeResponse employee;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterStation.class)
    StationResponse station;

    @Column(columnDefinition = "Integer default 0")
    Integer vote;

    @Column(columnDefinition = "text")
    String content;

    @Column(columnDefinition = "varchar(20)")
    String orderCode;
}
