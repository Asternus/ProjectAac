package com.aac.repository;

import com.aac.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Long> {

    List<People> findAllById(Long id);

    People findByUsername(String username);

}
