package com.admin_management.repository;

public interface InsertUpdateRepository<T> {
    <S extends T> S insert(S entity);

    <S extends T> S update(S entity);
}
