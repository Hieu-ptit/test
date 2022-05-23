package com.permission.mapper;

import com.permission.model.entity.Feature;
import com.permission.model.response.FeatureResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class FeatureMapper {

    /**
     * map List<Feature> to List<FeatureResponse>
     *
     * @param features features
     * @return List<FeatureResponse>
     */
    public List<FeatureResponse> map(List<Feature> features, List<Integer> featureIds) {

        Set<Feature> featuresUnique = new HashSet<>(features);

        if (!CollectionUtils.isEmpty(featureIds))
            return CollectionUtils.isEmpty(featuresUnique) ? new ArrayList<>() :
                    featuresUnique.stream()
                            .filter(Objects::nonNull)
                            .map(it -> map(it, featureIds))
                            .collect(Collectors.toList());

        return CollectionUtils.isEmpty(featuresUnique) ? new ArrayList<>() :
                featuresUnique.stream()
                        .filter(Objects::nonNull)
                        .map(this::map)
                        .collect(Collectors.toList());
    }

    /**
     * map Feature to FeatureResponse if list feature not exist
     *
     * @param feature feature
     * @return FeatureResponse
     */
    public FeatureResponse map(Feature feature) {
        return new FeatureResponse().setId(feature.getId())
                .setName(feature.getName())
                .setMethod(feature.getMethod());
    }

    /**
     * map Feature to FeatureResponse if list feature exist
     *
     * @param feature feature
     * @return FeatureResponse
     */
    public FeatureResponse map(Feature feature, List<Integer> featureIds) {
        return new FeatureResponse().setId(feature.getId())
                .setName(feature.getName())
                .setMethod(feature.getMethod())
                .setChecked(featureIds.contains(feature.getId()));
    }

}
