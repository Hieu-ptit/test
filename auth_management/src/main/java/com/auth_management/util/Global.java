package com.auth_management.util;

import com.auth_management.model.request.*;
import com.auth_management.model.response.*;
import com.common.model.ManagerClaim;
import com.common.model.response.Response;
import com.common.util.Json;
import com.dslplatform.json.JsonReader;
import com.dslplatform.json.JsonWriter;
import com.dslplatform.json.runtime.Generics;

import javax.validation.constraints.NotNull;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Set;

public class Global {

    public static final JsonReader.ReadObject<ManagerClaim> managerClaimReader = Json.findReader(ManagerClaim.class);

    public static final JsonReader.ReadObject<Response<AccountAuth>> accountAuthReader = Json.findReader(
            Generics.makeParameterizedType(Response.class, AccountAuth.class));

    public static final JsonReader.ReadObject<Response<Boolean>> booleanReader = Json.findReader(
            Generics.makeParameterizedType(Response.class, Boolean.class));


    public static final JsonReader.ReadObject<HttpResponse<byte[]>> httpResponseRead = Json.findReader(
            Generics.makeParameterizedType(HttpResponse.class, byte.class));

    public static final JsonReader.ReadObject<Response<Set<String>>> setStringReader = Json.findReader(
            Generics.makeParameterizedType(Response.class, Generics.makeParameterizedType(Set.class, String.class)));

    public static final JsonWriter.WriteObject<ChangePasswordLoginFirstTimes> changePasswordLoginFirstTimesWriteObject =
            Json.findWriter(ChangePasswordLoginFirstTimes.class);

    public static final JsonReader.ReadObject<Response<MediaResponse>> fileReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, MediaResponse.class));

    public static final JsonReader.ReadObject<Map<Integer, Map<String, Integer>>> bitSetReader =
            Json.findReader(Generics.makeParameterizedType(Map.class, Integer.class,
                    Generics.makeParameterizedType(Map.class, String.class, Integer.class)));

    public static final JsonReader.ReadObject<Response<RoleResponseDetail>> roleInfosReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, RoleResponseDetail.class));

    public static final JsonWriter.WriteObject<CreateFile> fileWriter = Json.findWriter(CreateFile.class);

    public static final JsonReader.ReadObject<Response<ImageSpeedometerResponse>> fileImageSpeedometerReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, ImageSpeedometerResponse.class));

    public static final JsonWriter.WriteObject<ImageSpeedometerRequest> fileImageSpeedometerWriter
            = Json.findWriter(ImageSpeedometerRequest.class);

    public static final JsonReader.ReadObject<Response<ImageLicensePlatesResponse>> fileImagePlateReader =
            Json.findReader(Generics.makeParameterizedType(Response.class, ImageLicensePlatesResponse.class));

    public static final JsonWriter.WriteObject<ImageLicensePlatesRequest> fileImagePlateWriter = Json.findWriter(ImageLicensePlatesRequest.class);

    public static final JsonWriter.WriteObject<AuthorRequest> authorRequestWriter = Json.findWriter(AuthorRequest.class);

    public static final JsonReader.ReadObject<LicensePlateResponse> getLicensePlateResponsesReader = Json.findReader(LicensePlateResponse.class);

}
