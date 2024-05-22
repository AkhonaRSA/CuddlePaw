package com.balenii.groupi.cuddlepaw_cottage.Repository;

import com.balenii.groupi.cuddlepaw_cottage.Entities.AdoptApplication;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdoptionApplicationRepository extends MongoRepository<AdoptApplication, String> {


    void deleteByPetName(String petName);

}
