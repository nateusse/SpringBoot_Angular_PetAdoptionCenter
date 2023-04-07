package com.adoptioncenter.model;

import jakarta.persistence.*;

import java.io.Serializable;


/*
why Serializable? Transforms this java class into differents type of streams,
because is going to be sent as a database / to the front as JSON ..
 */
@Entity
public class Customer implements Serializable {

    public Customer(String name, String email, Integer age, String jobTitle, String imageUrl) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.jobTitle = jobTitle;
        this.imageUrl = imageUrl;
    }

    public Customer() {}

    @Id
    @SequenceGenerator(
            name="custumer_id_sequence",
            sequenceName = "custumer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "customer_id_sequence"
      )
    @Column(nullable = false, updatable = false) // no se update
    private Long id;
    private String name;
    private String email;
    private Integer age;

    private String jobTitle;

    //Type String to pint the location, instead of file even the image will be stored in the server
    private String imageUrl;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
