package com.project.registerapi.service;

import com.project.registerapi.model.City;
import com.project.registerapi.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City registerCity(City city){

        return cityRepository.save(city);
    }

    public City findCityByNameAndState(String name, String state){

        return cityRepository.findByNameAndState(name, state);
    }

    public City findCityByName(String name){

        return cityRepository.findByName(name);
    }

    public List<City> findCityByState(String state){

        return cityRepository.findByState(state);
    }

}
