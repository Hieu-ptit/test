package com.permission.config;

import com.permission.model.bo.Method;
import com.permission.model.entity.Feature;
import com.permission.model.entity.Group;
import com.permission.model.entity.GroupFeature;
import com.permission.service.FeatureInternalService;
import com.permission.service.GroupFeatureInternalService;
import com.permission.service.GroupInternalService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PermissionData {

    /**
     * where Groups are stored.
     */
    public List<Group> groups;

    /**
     * where Groups are stored.
     * key: group id
     * value: Group
     */
    public Map<String, Group> idNGroupMap;

    /**
     * where Group and Feature are stored.
     * key: group id
     * value: Feature object List has same group id
     * never null or empty
     */
    public Map<String, List<Feature>> groupFeatureMap = new HashMap<>();

    /**
     * where Features are stored.
     * key: path is Feature Object
     * value: Feature object List has same path
     * never null or empty
     */
    public Map<String, List<Feature>> pathNFeatureMap;

    /**
     * where Features are stored.
     * key: feature id
     * value: Feature object has that id
     * never null or empty
     */
    public Map<Integer, Feature> idNFeatureMap;

    /**
     * where GroupFeature are stored.
     * key: feature id
     * value: group id
     * never null or empty
     */
    public Map<Integer, String> idFeatureNIdGroupMap;


    private final Logger logger = LogManager.getLogger(getClass());
    private final GroupInternalService groupInternalService;
    private final FeatureInternalService featureInternalService;
    private final GroupFeatureInternalService groupFeatureService;
    private final Killer killer;


    /**
     * Run after Application started
     * <p>
     * Query into DB,
     * load Groups up to Service. After, save Group to the @groups
     * load Features up to Service. After, save Feature handled to the @pathNFeatureMap, @idNFeatureMap
     * load GroupFeatures up to Service. After, save GroupFeature handled to the @groupFeatureMap
     * <p>
     * If there are not one in three Object (Group, Feature, GroupFeature), then Kill Application
     */
    @PostConstruct
    @Scheduled(fixedDelayString = "${app.scheduled.permission.load-when-start}")
    public void loadGroups() {
        this.groups = groupInternalService.findAll();
        if (CollectionUtils.isEmpty(groups))
            killer.kill("Could not found Group !!!, System Error !");

        idNGroupMap = groups.stream().collect(Collectors.toMap(Group::getId, it -> it));

        List<Feature> features = featureInternalService.findAll();
        if (CollectionUtils.isEmpty(features))
            killer.kill("Could not found Feature !!!, System Error !");

        idNFeatureMap = features.stream().collect(Collectors.toMap(Feature::getId, it -> it));
        pathNFeatureMap = features.stream().collect(Collectors.groupingBy(Feature::getPath));

        List<GroupFeature> groupFeatures = groupFeatureService.findAll();
        if (CollectionUtils.isEmpty(groupFeatures))
            killer.kill("Could not found GroupFeature !!!, System Error !");

        idFeatureNIdGroupMap = groupFeatures.stream()
                .collect(Collectors.toMap(GroupFeature::getFeatureId, GroupFeature::getGroupId));

        genGroupFeatureMap(groupFeatures);
    }

    /**
     * Find Feature By Path and Method
     *
     * @param path
     * @param method
     * @return
     */
    public Feature findFeatureByPathNMethod(String path, Method method) {
        List<Feature> features = this.pathNFeatureMap.get(path);

        if (CollectionUtils.isEmpty(features))
            features = getFeaturesByPathExtra(path);

         if (CollectionUtils.isEmpty(features))
            return null;

        for (Feature feature : features)
            if (feature.getMethod() == method)
                return feature;

        return null;
    }

    private List<Feature> getFeaturesByPathExtra(String path) {
        String pathExtra = path.substring(0, path.lastIndexOf("/") + 1) + "{id}";
        return this.pathNFeatureMap.get(pathExtra);
    }


    /**
     * Generate Group contains Features
     *
     * @param groupFeatures
     */
    private void genGroupFeatureMap(List<GroupFeature> groupFeatures) {

        groupFeatureMap.clear();
        for (GroupFeature it : groupFeatures) {

            List<Feature> featuresInMap = groupFeatureMap.get(it.getGroupId());
            if (featuresInMap != null) {
                featuresInMap.add(idNFeatureMap.get(it.getFeatureId()));
                continue;
            }

            List<Feature> featureLst = new ArrayList<>();
            featureLst.add(idNFeatureMap.get(it.getFeatureId()));
            groupFeatureMap.put(it.getGroupId(), featureLst);
        }
    }

}
