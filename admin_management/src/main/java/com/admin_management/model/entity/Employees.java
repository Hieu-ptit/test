package com.admin_management.model.entity;

import com.admin_management.converter.*;
import com.admin_management.model.bo.*;
import com.admin_management.model.response.FileResponse;
import com.admin_management.model.response.PropertiesResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.List;

@Entity(name = "employees")
@Table(indexes = {

})
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class Employees extends BaseEntity {

    @Id
    @SequenceGenerator(name = "employees_id_seq", sequenceName = "employees_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_id_seq")
    Integer id;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterImages.class)
    CredentialImages avatar;

    @Column(length = 50)
    String code;

    @Column(columnDefinition = "varchar(99)")
    String name;

    @Column(columnDefinition = "timestamp")
    OffsetDateTime dateOfBirth;

    @Column(columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    Gender sex;

    @Column(columnDefinition = "varchar(20)")
    String phone;

    @Column(length = 50, columnDefinition = "text")
    String email;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterProperties.class)
    PropertiesResponse department;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterProperties.class)
        PropertiesResponse positions;

    @Column
    String accountId;

    @Column(columnDefinition = "varchar(100)")
    String nation;

    @Column(columnDefinition = "varchar(100)")
    String religion;

    @Column(length = 100)
    String address;

    @Column
    String identityCardNumber;

    @Column(columnDefinition = "timestamp")
    OffsetDateTime dateRange;

    @Column(columnDefinition = "varchar(100)")
    String fullAddress;

    @Column(length = 264, columnDefinition = "text")
    String supplyAddress;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConvertLocation.class)
    LocationDetail province;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConvertLocation.class)
    LocationDetail district;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConvertLocation.class)
    LocationDetail ward;

    @Column(columnDefinition = "varchar(20)")
    @Enumerated(EnumType.STRING)
    MaritalStatus maritalStatus;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterList.class)
    List<CredentialImages> credentialImages;

    @Column(columnDefinition = "jsonb")
    @Convert(converter = JsonConverterAttachmentList.class)
    List<FileResponse> attachment;

    @Column(columnDefinition = "varchar(20) default 'ACTIVE'")
    @Enumerated(EnumType.STRING)
    EmployeeStatus status;
}
