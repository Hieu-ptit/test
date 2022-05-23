package com.admin_management.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
public class InsertUpdateRepositoryImpl<T> implements InsertUpdateRepository<T> {

    private final EntityManager entityManager;

    @Transactional
    @Override
    public <S extends T> S insert(S entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    @Override
    public <S extends T> S update(S entity) {
        return entityManager.merge(entity);
    }

}
