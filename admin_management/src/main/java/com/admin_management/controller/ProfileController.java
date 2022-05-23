package com.admin_management.controller;

import com.admin_management.model.request.AvatarRequest;
import com.admin_management.model.response.ProfileResponse;
import com.admin_management.service.ProfileService;
import com.admin_management.service.impl.InfoInJwt;
import com.common.model.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profiles")
@Validated
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    private final InfoInJwt infoInJwt;

    @GetMapping()
    public Response<ProfileResponse> findProfileById(@RequestHeader("Authorization") String token,
                                                     @RequestParam(value = "check-app", defaultValue = "false") Boolean checkApp) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(profileService.findProfileById(accountId, checkApp));
    }

    @PutMapping("/avatar")
    public Response<Boolean> updateAvatar(@RequestHeader("Authorization") String token,
                                          @Valid @RequestBody AvatarRequest avatarRequest) {
        String accountId = infoInJwt.getPayload(token).getAccountId();
        return Response.ofSucceeded(profileService.updateAvatar(accountId, avatarRequest));
    }


}
