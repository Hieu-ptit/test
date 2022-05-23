package com.admin_management.service;

import com.admin_management.model.request.AvatarRequest;
import com.admin_management.model.response.ProfileResponse;

public interface ProfileService {

    ProfileResponse findProfileById(String accountId, Boolean checkApp);

    /**
     * API update avatar in profile
     *
     * @param accountId
     * @param avatarRequest
     * @return
     */
    Boolean updateAvatar(String accountId, AvatarRequest avatarRequest);
}
