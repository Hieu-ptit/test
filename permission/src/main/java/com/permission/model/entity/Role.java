package com.permission.model.entity;

import com.permission.converter.BitSetModuleConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "roles")
@Data
@Accessors(chain = true)
public class Role extends BaseEntity {

    @Id
    @SequenceGenerator(name = "roles_id_seq", sequenceName = "roles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_id_seq")
    private Integer id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(columnDefinition = "jsonb", nullable = false)
    @Convert(converter = BitSetModuleConverter.class)
    private Map<String, Integer> bitSetModule;

}
