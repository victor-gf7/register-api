package com.project.registerapi.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.registerapi.model.City;
import com.project.registerapi.model.Client;

import java.time.LocalDate;

public class ClientRequest {

    private String fullName;
    private String gender;

    @JsonProperty("dateBirth")
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dateBirth;

    private int age;
    private City city;

    public ClientRequest(String fullName, String gender, LocalDate dateBirth, int age, City city) {
        super();
        this.fullName = fullName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.age = age;
        this.city = city;
    }
    public Client toModel(){
        return new Client(this.fullName, this.gender, this.dateBirth, this.age, this.city);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }


}
