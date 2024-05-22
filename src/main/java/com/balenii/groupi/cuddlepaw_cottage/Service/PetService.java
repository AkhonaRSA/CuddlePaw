package com.balenii.groupi.cuddlepaw_cottage.Service;

import com.balenii.groupi.cuddlepaw_cottage.Entities.Pet;
import com.balenii.groupi.cuddlepaw_cottage.Repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository; // Assuming you have a PetRepository interface

    @Autowired
    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Transactional
    public void deletePetByName(String petName) {
        List<Pet> petList = petRepository.findAll();
        Pet pet = null;

        for(Pet p: petList){
            if(p.getName().equalsIgnoreCase(petName)){
                pet = p;
                break;
            }
        }

        if (pet != null) {
            // Delete the pet from the database
            petRepository.delete(pet);
        } else {
            //throw new PetNotFoundException("Pet with name '" + petName + "' not found.");
        }
    }
}
