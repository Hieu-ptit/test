package com.permission.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "group_feature")
@Data
@Accessors(chain = true)
public class GroupFeature {

    @Id
    @SequenceGenerator(name = "group_feature_seq", sequenceName = "group_feature_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_feature_seq")
    private Integer id;

    @Column(nullable = false)
    private Integer featureId;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String groupId;

}
