package com.project.registerapi.model;


import com.project.registerapi.request.CityRequest;
import com.project.registerapi.request.ClientRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private @NotBlank String name;
    private @NotBlank String state;

    @Deprecated
    public City() {
    }

    public City(@NotBlank String name, @NotBlank String state) {
        this.name = name;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CityRequest toRequest(){
        return new CityRequest(this.name, this.state);
    }

}
