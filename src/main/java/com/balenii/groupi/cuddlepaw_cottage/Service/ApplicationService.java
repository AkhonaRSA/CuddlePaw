package com.balenii.groupi.cuddlepaw_cottage.Service;

import com.balenii.groupi.cuddlepaw_cottage.Entities.AdoptApplication;
import com.balenii.groupi.cuddlepaw_cottage.Entities.Pet;
import com.balenii.groupi.cuddlepaw_cottage.Repository.AdoptionApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    AdoptionApplicationRepository adoptionApplicationRepository;

    @Transactional
    public void deleteAppByName(String formId) {
        List<AdoptApplication> appList = adoptionApplicationRepository.findAll();
        AdoptApplication aa = null;

        for(AdoptApplication a: appList){
            if(a.getFormId().equalsIgnoreCase(formId)){
                aa = a;
                break;
            }
        }

        if (aa != null) {
            // Delete the pet from the database
            adoptionApplicationRepository.delete(aa);
        } else {
            //throw new PetNotFoundException("Pet with name '" + petName + "' not found.");
        }
    }

}
