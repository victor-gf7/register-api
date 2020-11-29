package com.project.registerapi.controller;

import com.project.registerapi.model.City;
import com.project.registerapi.request.CityRequest;
import com.project.registerapi.response.Response;
import com.project.registerapi.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/public/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Response<CityRequest>> registerCity(@Valid @RequestBody CityRequest cityRequest){

        Response<CityRequest> response = new Response<>();

        City city = cityRequest.toModel();

        CityRequest requestSaved = cityService.registerCity(city).toRequest();

        response.setData(requestSaved);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(value = "name/{cityName}")
    public  ResponseEntity<Response<CityRequest>> findCityByName(@Valid @PathVariable("cityName") String name){

        Response<CityRequest> response = new Response<>();

        City city = cityService.findCityByName(name);

        CityRequest request = city.toRequest();

        response.setData(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "state/{cityState}")
    public  ResponseEntity<Response<List<City>>> findCityByState(@Valid @PathVariable("cityState") String state){

        Response<List<City>> response = new Response<>();

        List<City> city = cityService.findCityByState(state);

        if(city.size() <= 0){
            response.setErrors("This state does not exist or has not been registered.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }


        response.setData(city);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
