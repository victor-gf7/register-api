package com.project.registerapi.request;

import com.project.registerapi.model.City;

import javax.validation.constraints.NotBlank;

public class CityRequest {

    private @NotBlank String name;
    private @NotBlank String state;

    public CityRequest(@NotBlank String name, @NotBlank String state) {
        super();
        this.name = name;
        this.state = state;
    }

    public City toModel(){
        return new City(this.name,this.state);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
