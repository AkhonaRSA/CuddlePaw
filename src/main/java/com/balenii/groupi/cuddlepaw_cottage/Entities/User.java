package com.balenii.groupi.cuddlepaw_cottage.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document(collection = "user" )
public class User {

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String role;

    public User(String firstName, String lastName, String email, String password, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
