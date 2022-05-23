package com.permission.service.impl;

import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.permission.mapper.GroupMapper;
import com.permission.model.entity.Group;
import com.permission.model.response.GroupInfo;
import com.permission.model.response.GroupResponse;
import com.permission.repository.GroupRepository;
import com.permission.service.GroupService;
import com.permission.service.ModuleInternalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    public final GroupRepository groupRepository;

    public final ModuleInternalService moduleInternalService;

    public final GroupMapper groupMapper;

    @Override
    public List<GroupResponse> getAllByModuleId(int moduleId) {
        var groups = groupRepository.findByModuleId(moduleId);

        return groupMapper.map(groups);
    }

    @Override
    public List<GroupInfo> getAll() {
        var groups = groupRepository.findAll();

        return groupMapper.mapTo(groups);
    }

    /**
     * Check a list of group id whether is contained by module
     *
     * @param moduleId   int
     * @param groupIdSet Set
     * @return boolean
     */
    @Override
    public Boolean validateGroups(int moduleId, Set<String> groupIdSet) {

        if (!moduleInternalService.doesModuleExist(moduleId)) {
            throw new BusinessException(ErrorCode.MODULE_NOT_EXISTS, "4200");
        }

        var groups = groupRepository.findByModuleId(moduleId);

        var groupContainedByModule = groups.stream().map(Group::getId).collect(Collectors.toSet());

        return groupContainedByModule.containsAll(groupIdSet);
    }
}
