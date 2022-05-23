package com.permission.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "histories")
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class History extends BaseEntity{

    @Id
    @SequenceGenerator(name = "histories_id_seq", sequenceName = "histories_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "histories_id_seq")
    Integer id;

    @Column(length = 100, nullable = false)
    String code;

    @Column(length = 100)
    String name;

    @Column(length = 200)
    String description;

}
