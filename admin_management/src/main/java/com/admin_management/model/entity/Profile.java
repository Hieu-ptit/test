package com.admin_management.model.entity;

import com.admin_management.converter.JsonConverterImages;
import com.admin_management.model.bo.CredentialImages;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity(name = "profiles")
@Table(indexes = {
        @Index(name="idx_profile_name", columnList = "name")
})
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Profile extends BaseEntity {

    @Id
    @SequenceGenerator(name = "profiles_id_seq", sequenceName = "profiles_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profiles_id_seq")
    Integer id;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    String name;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterImages.class)
    CredentialImages avatar;

    @Column(columnDefinition = "varchar(20)")
    String phone;

    @Column(columnDefinition = "varchar(300)")
    String address;

}
