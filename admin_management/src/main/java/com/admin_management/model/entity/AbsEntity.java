package com.admin_management.model.entity;

import com.common.util.Constant;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public abstract class AbsEntity extends BaseEntity {
    @Id
    @Column(length = 64)
    String id;

    @PrePersist()
    @Override
    public void onCreate() {
        id = Constant.generateUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}