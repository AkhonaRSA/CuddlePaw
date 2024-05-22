package com.balenii.groupi.cuddlepaw_cottage.Repository;

import com.balenii.groupi.cuddlepaw_cottage.Entities.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PetRepository extends MongoRepository<Pet, String> {


}
