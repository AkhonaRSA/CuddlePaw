package com.balenii.groupi.cuddlepaw_cottage.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "pet" )
public class Pet {

    @Id
    private String id;
    private String name;
    private String species;
    private String breed;
    private String imageUrl;
    private String briefInfo;
    private int age;

    public Pet(String name, String species, String breed, String imageUrl, String briefInfo, int age) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.imageUrl = imageUrl;
        this.briefInfo = briefInfo;
        this.age = age;
    }


}
