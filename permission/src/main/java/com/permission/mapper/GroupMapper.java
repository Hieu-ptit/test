package com.permission.mapper;

import com.permission.model.entity.Group;
import com.permission.model.response.GroupInfo;
import com.permission.model.response.GroupResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    public GroupResponse map(Group group) {
//        return new GroupResponse().setId(group.getId())
//                .setName(group.getName())
//                .setDescription(group.getDescription());
        return null;
    }

    public List<GroupResponse> map(List<Group> groups) {
        return groups.stream().map(this::map).collect(Collectors.toList());
    }

    public GroupInfo mapTo(Group group){
        return new GroupInfo()
                .setName(group.getName())
                .setCode(group.getId());
    }

    public List<GroupInfo> mapTo(List<Group> groups) {
        return groups.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
