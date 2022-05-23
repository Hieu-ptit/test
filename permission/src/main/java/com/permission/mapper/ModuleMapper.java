package com.permission.mapper;

import com.permission.model.entity.Feature;
import com.permission.model.entity.Group;
import com.permission.model.entity.Module;
import com.permission.model.response.FeatureResponse;
import com.permission.model.response.GroupResponse;
import com.permission.model.response.ModuleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ModuleMapper {

    private final FeatureMapper featureMapper;

    /**
     * map to List<ModuleResponse>
     *
     * @param modules         modules
     * @param groups          groups
     * @param groupFeatureMap groupFeatureMap
     * @return List<ModuleResponse>
     */
    public List<ModuleResponse> map(List<Module> modules,
                                    List<Group> groups,
                                    Map<String, List<Feature>> groupFeatureMap,
                                    List<Integer> featureIds) {

        List<GroupResponse> groupResponses = map(groups, groupFeatureMap, featureIds);

        return modules.stream()
                .map(it -> map(it, groupResponses))
                .collect(Collectors.toList());
    }

    /**
     * map to ModuleResponse
     *
     * @param module         module
     * @param groupResponses groupResponses
     * @return ModuleResponse
     */
    public ModuleResponse map(Module module, List<GroupResponse> groupResponses) {
        groupResponses = groupResponses.stream().filter(it -> it.getModuleId() == module.getId()).collect(Collectors.toList());
        List<Boolean> checked = groupResponses.stream().map(GroupResponse::isChecked).collect(Collectors.toList());
        return new ModuleResponse().setId(module.getId())
                .setName(module.getName())
                .setGroups(groupResponses)
                .setChecked(checked.contains(true));
    }

    /**
     * Map to List<GroupResponse>
     *
     * @param groups groups
     * @return List<GroupResponse>
     */
    public List<GroupResponse> map(List<Group> groups, Map<String, List<Feature>> groupFeatureMap, List<Integer> featureIds) {

        if(CollectionUtils.isEmpty(groups)) return new ArrayList<>();

        return groups.stream()
                .map(it -> map(it, groupFeatureMap, featureIds))
                .collect(Collectors.toList());
    }

    /**
     * map GroupResponse
     *
     * @param group group
     * @return GroupResponse
     */
    public GroupResponse map(Group group, Map<String, List<Feature>> groupFeatureMap, List<Integer> featureIds) {
        List<FeatureResponse> features = featureMapper.map(groupFeatureMap.get(group.getId()), featureIds);

        List<Boolean> checked = features.stream()
                .map(FeatureResponse::isChecked)
                .collect(Collectors.toList());

        return new GroupResponse().setId(group.getId())
                .setName(group.getName())
                .setModuleId(group.getModuleId())
                .setFeatures(features)
                .setChecked(checked.contains(true));
    }

}
