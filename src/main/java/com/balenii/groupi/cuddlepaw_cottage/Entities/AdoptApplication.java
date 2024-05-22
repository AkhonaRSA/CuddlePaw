package com.balenii.groupi.cuddlepaw_cottage.Entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Setter
@Getter
@Document
public class AdoptApplication {

    @Id
    private String formId;
    private String fullName;
    private String homeAddress;
    private String email;
    private String petName;
    private String contact;
    private LocalDateTime visitDateTime;

    public AdoptApplication() {
    }

    public AdoptApplication(String fullName, String homeAddress, String email, String petName,String contact,  LocalDateTime visitDateTime) {
        this.fullName = fullName;
        this.homeAddress = homeAddress;
        this.email = email;
        this.petName = petName;
        this.contact = contact;
        this.visitDateTime = visitDateTime;
    }


}
