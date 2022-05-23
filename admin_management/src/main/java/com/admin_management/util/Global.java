package com.admin_management.util;

import com.admin_management.caller.StationNameResponse;
import com.admin_management.model.bo.CredentialImages;
import com.admin_management.model.request.*;
import com.admin_management.model.response.*;
import com.common.model.AccountClaim;
import com.common.model.bo.AccountStatus;
import com.common.model.response.Response;
import com.common.util.Json;
import com.dslplatform.json.JsonReader;
import com.dslplatform.json.JsonWriter;
import com.dslplatform.json.runtime.Generics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Global {

    public Global() {
    }

    public static final List<String> bodyEvaluation =  Arrays.asList("code","date", "stationName", "vote", "content");

    public static Map<String, String> headerFilterAdminMap;

    static {

        headerFilterAdminMap = new HashMap<>();
        headerFilterAdminMap.put("code", "Mã đơn hàng");
        headerFilterAdminMap.put("date", "Thời gian");
        headerFilterAdminMap.put("stationName", "Trạm");
        headerFilterAdminMap.put("vote", "Đánh giá");
        headerFilterAdminMap.put("content", "Ý kiến bình luận");
    }

    public static final JsonReader.ReadObject<AccountClaim> driveClaimReader = Json.findReader(AccountClaim.class);

    public static final List<AccountStatus> lstStatusLogin = Arrays.asList(AccountStatus.ACTIVE, AccountStatus.FIRST);

    public final static List<String> fieldSortAccount = Arrays.asList("username", "code", "status", "created_at");

    public static final JsonWriter.WriteObject<CreateRolesAccountRequest> createRolesAccountWriter =
            Json.findWriter(CreateRolesAccountRequest.class);

    public static final JsonWriter.WriteObject<UpdateRolesAccountRequest> updateRolesAccountWriter =
            Json.findWriter(UpdateRolesAccountRequest.class);

    public static final JsonWriter.WriteObject<ValidateRolesRequest> validateRolesWriter =
            Json.findWriter(ValidateRolesRequest.class);

    public static final JsonReader.ReadObject<Response<RoleResponseDetail>> proleResponseDetailReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, RoleResponseDetail.class));

    public static final JsonReader.ReadObject<Response<Boolean>> deleteDriver =
            Json.findReader(Generics.makeParameterizedType(Response.class, Boolean.class));

    public static final JsonReader.ReadObject<Response<Boolean>> checkDriver =
            Json.findReader(Generics.makeParameterizedType(Response.class, Boolean.class));

    public static final JsonReader.ReadObject<List<CredentialImages>> listReader =
            Json.findReader(Generics.makeParameterizedType(List.class, CredentialImages.class));

    public final static String EMPLOYEE_CODE_NO_SEQUENCE = "employee_code_no_seq";

    public static final JsonReader.ReadObject<Response<PropertiesResponse>> propertiesReaders =
            Json.findReader(Generics.makeParameterizedType(Response.class, PropertiesResponse.class));

    public final static List<String> fieldSortEmployee = Arrays.asList("code", "createdAt", "name", "department", "positions");

    public static final JsonWriter.WriteObject<CreateEmployeeStationRequests> employeeStationWriter =
            Json.findWriter(CreateEmployeeStationRequests.class);

    public static final JsonWriter.WriteObject<MediaRequest> mediaRequestWriter =
            Json.findWriter(MediaRequest.class);

    public static final JsonReader.ReadObject<Response<Boolean>> employeeStationReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, Boolean.class));

    public static final JsonReader.ReadObject<List<FileResponse>> listAttachmentReader =
            Json.findReader(Generics.makeParameterizedType(List.class, FileResponse.class));

    public static final JsonReader.ReadObject<Response<FileResponse>> fileReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, FileResponse.class));

    public static final JsonReader.ReadObject<Response<List<DistrictResponse>>> districtReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, Generics.makeParameterizedType(List.class, DistrictResponse.class)));

    public static final JsonReader.ReadObject<Response<List<WardResponse>>> wardsReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, Generics.makeParameterizedType(List.class, WardResponse.class)));
    public static final JsonReader.ReadObject<Response<WardResponse>> wardReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, WardResponse.class));

    public static final JsonReader.ReadObject<Response<StationResponse>> stationReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, StationResponse.class));
    public static final JsonReader.ReadObject<Response<List<StationResponse>>> stationsReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, Generics.makeParameterizedType(List.class, StationResponse.class)));

    public static String getFunctionPostgres = "jsonb_extract_path_text";

    public static final JsonReader.ReadObject<Response<List<StationResponse>>> stationListReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, Generics.makeParameterizedType(List.class, StationResponse.class)));

    public static final JsonReader.ReadObject<Response<List<EmployeeResponse>>> employeeReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, Generics.makeParameterizedType(List.class, EmployeeResponse.class)));

    public static JsonReader.ReadObject<?> qrCodeReader = Json.findReader(Generics.makeParameterizedType(Response.class, Object.class));

    public static final JsonReader.ReadObject<Response<Boolean>> booleanReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, Boolean.class));

    public static JsonReader.ReadObject<Response<List<StationNameResponse>>> getStationName =
            Json.findReader(Generics.makeParameterizedType(Response.class, Generics.makeParameterizedType(List.class, StationNameResponse.class)));
}
