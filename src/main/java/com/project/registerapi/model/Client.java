package com.project.registerapi.model;

import com.project.registerapi.request.ClientRequest;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private @NotBlank String fullName;
    private @NotBlank String gender;
    private LocalDate dateBirth;
    private @NotNull int age;

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    @Deprecated
    public Client() {
    }

    public Client(@NotBlank String fullName, @NotBlank String gender, @NotBlank LocalDate dateBirth, @NotNull int age, City city) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.age = age;
        this.city = city;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
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

    public ClientRequest toRequest(){
        return new ClientRequest(this.fullName, this.gender, this.dateBirth, this.age, this.city);
    }
}
