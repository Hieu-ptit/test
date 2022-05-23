package com.admin_management.model.response;

import com.admin_management.model.bo.CredentialImages;
import com.admin_management.model.bo.Gender;
import com.admin_management.model.bo.LocationDetail;
import com.admin_management.model.bo.MaritalStatus;
import com.dslplatform.json.CompiledJson;
import com.dslplatform.json.JsonAttribute;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@Accessors(chain = true)
@CompiledJson
public class EmployeeDetail {

    private Integer id;

    private CredentialImages avatar;

    private String code;

    private String name;

    private OffsetDateTime dateOfBirth;

    private Gender sex;

    private String phone;

    private String email;

    private PropertiesResponse department;

    private PropertiesResponse positions;

    @JsonAttribute(name = "account_id")
    private String accountId;

    private String nation;

    private String religion;

    private String address;

    private String identityCardNumber;

    private OffsetDateTime dateRange;

    private String fullAddress;

    private String supplyAddress;

    private LocationDetail province;

    private LocationDetail district;

    private LocationDetail ward;

    private MaritalStatus maritalStatus;

    private List<CredentialImages> credentialImages;

    private List<FileResponse> attachment;

    private List<StationResponse> stationList;
}
