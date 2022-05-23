package com.permission.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "role_group")
@Data
@Accessors(chain = true)
public class RoleGroup {

    @Id
    @SequenceGenerator(name = "role_group_id_seq", sequenceName = "role_group_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_group_id_seq")
    private Integer id;

    @Column(nullable = false)
    private Integer roleId;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String groupId;
}
