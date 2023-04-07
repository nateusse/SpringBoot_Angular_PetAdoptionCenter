package com.adoptioncenter.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
/*
why Serializable? Transforms this java class into differents type of streams,
because is going to be sent as a database / to the front as JSON ..
 */

@Entity
public class Animal  implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private boolean adopted;

    public Animal(String name, String species, String breed, Integer age, boolean adopted) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.adopted = adopted;
    }

    public Animal(){}

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

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }


}
