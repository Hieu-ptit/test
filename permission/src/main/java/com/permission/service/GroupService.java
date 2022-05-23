package com.permission.service;

import com.permission.model.response.GroupInfo;
import com.permission.model.response.GroupResponse;

import java.util.List;
import java.util.Set;

public interface GroupService {

    List<GroupResponse> getAllByModuleId(int moduleId);

    List<GroupInfo> getAll();

    Boolean validateGroups(int moduleId, Set<String> groupIdSet);

}
