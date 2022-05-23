package com.permission.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "role_account")
@Data
@Accessors(chain = true)
public class RoleAccount extends BaseEntity {

    @Id
    @SequenceGenerator(name = "role_account_id_seq", sequenceName = "role_account_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_account_id_seq")
    private Integer id;

    @Column(length = 100, nullable = false)
    private String accountId;

    @Column(nullable = false)
    private Integer roleId;

}
