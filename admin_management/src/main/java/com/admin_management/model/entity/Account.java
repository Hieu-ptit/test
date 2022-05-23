package com.admin_management.model.entity;

import com.common.model.bo.AccountStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity(name = "accounts")
@Table(indexes = {
        @Index(name="idx_driver_phone", columnList = "username"),
        @Index(name="idx_driver_status", columnList = "status")
})
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Account extends AbsEntity {

    @Column(length = 20, nullable = false)
    String code;

    @Column(length = 50, nullable = false)
    String username;

    @Column(length = 100, nullable = false)
    String hashPassword;

    @Column(columnDefinition = "varchar(20) default 'INACTIVE'", nullable = false)
    @Enumerated(EnumType.STRING)
    AccountStatus status;

    @Column(columnDefinition = "int default 0")
    int profileId;

    @Column(columnDefinition = "Boolean default false")
    Boolean authenticationOtp;

}
