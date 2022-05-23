package com.admin_management.service.impl;

import com.admin_management.mapper.ProfileMapper;
import com.admin_management.model.entity.Employees;
import com.admin_management.model.entity.Profile;
import com.admin_management.repository.ProfileRepository;
import com.admin_management.service.ProfileInternalService;
import com.common.exception.BusinessException;
import com.common.util.ErrorCode;
import com.common.util.ErrorMessage;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class ProfileInternalServiceImpl implements ProfileInternalService {

    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    /**
     * find profile by ids
     *
     * @return Profile
     */
    public List<Profile> findByIdIn(Set<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) return new ArrayList<>();

        return repository.findByIdIn(ids);
    }

    /**
     * find profile by name like
     *
     * @return Profile
     */
    @Override
    public List<Profile> findByNameLike(String searchText) {

        if (StringUtils.isEmpty(searchText)) return new ArrayList<>();

        return repository.findByNameLike(searchText);
    }

    /**
     * find profile by id
     *
     * param id
     * @return Profile
     */
    @Override
    public Profile findById(Integer id) {
        return repository.findById(id).orElse(new Profile());

    }

    @Override
    public Profile update(Integer id, Employees employees) {

        Profile profile = repository.findById(id).orElseThrow(() ->
                new BusinessException(ErrorCode.PROFILE_IS_NULL, ErrorMessage.PROFILE_NOT_FOUND));

        return repository.update(mapper.map(profile, employees));
    }

}
