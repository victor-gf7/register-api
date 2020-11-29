package com.project.registerapi.repository;

import com.project.registerapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findByNameAndState(String name, String state);

    City findByName(String name);

    List<City> findByState(String state);
}
