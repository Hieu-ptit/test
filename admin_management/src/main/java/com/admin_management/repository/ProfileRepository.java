package com.admin_management.repository;

import com.admin_management.model.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer>, InsertUpdateRepository<Profile> {

    List<Profile> findByIdIn(Set<Integer> ids);

    @Query(value = "select * from profiles where lower(name) like ?1", nativeQuery = true)
    List<Profile> findByNameLike(String nameLike);

    Optional<Profile> findById(int id);
}
