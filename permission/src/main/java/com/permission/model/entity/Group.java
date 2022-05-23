package com.permission.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "groups")
@Data
@Accessors(chain = true)
public class Group {

    @Id
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private Integer moduleId;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 200)
    private String description;
}
