package com.permission.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "role_feature")
@Data
@Accessors(chain = true)
public class RoleFeature {

    @Id
    @SequenceGenerator(name = "role_feature_id_seq", sequenceName = "role_feature_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_feature_id_seq")
    private Integer id;

    @Column(nullable = false)
    private Integer featureId;

    @Column(nullable = false)
    private Integer roleId;

}
