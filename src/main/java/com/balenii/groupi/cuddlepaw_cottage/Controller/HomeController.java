package com.balenii.groupi.cuddlepaw_cottage.Controller;

import com.balenii.groupi.cuddlepaw_cottage.Entities.AdoptApplication;
import com.balenii.groupi.cuddlepaw_cottage.Entities.Pet;
import com.balenii.groupi.cuddlepaw_cottage.Entities.User;
import com.balenii.groupi.cuddlepaw_cottage.Repository.AdoptionApplicationRepository;
import com.balenii.groupi.cuddlepaw_cottage.Repository.PetRepository;
import com.balenii.groupi.cuddlepaw_cottage.Repository.UserRepository;
import com.balenii.groupi.cuddlepaw_cottage.Service.ApplicationService;
import com.balenii.groupi.cuddlepaw_cottage.Service.PetService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpFilter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository; // Assuming UserRepository is your JPA repository for users

    @Autowired
    private PetRepository petRepository;

    @Autowired
    PetService petService;

    @Autowired
    private AdoptionApplicationRepository adoptionApplicationRepository;

    @Autowired
    private ApplicationService applicationService;



    // Mapping to the home page
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    @GetMapping("/about_us")
    public String aboutUsPage(){ return "about_us";}

    // Mapping to the Admin dashboard
    @GetMapping("/adminDashboard")
    public String adminDashboard() {
        return "adminDashboard";
    }

    // Mapping to the User dashboard
    @GetMapping("/userDashboard")
    public String userDashboard() {
        return "userDashboard";
    }

    // Mapping to the Success page after Adding pet
    @GetMapping("/addPet_success")
    public String addPet_success() {
        return "addPet_success";
    }

    // Mapping to the Success page after submitting application
    @GetMapping("/ApplicationSuccess")
    public String ApplicationSuccess(){return "ApplicationSuccess";}

    // Mapping to the Admin view-pet page
    @GetMapping("/adminViewPets")
    public String adminViewPets() {
        return "adminViewPets";
    }

    // Mapping to the user registration page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Mapping to the login page
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    // Mapping to the adopt application form
    @GetMapping("/adoptForm")
    public String showAdoptionForm() {return "adoptForm";}

    @GetMapping("/viewApplications")
    public String viewApplications(){return "viewApplications";}

//    @GetMapping("/removePet")
//    public String removePet(){
//
//
//        return "removePet";}


    // Mapping to the Admin Pet adding form
    @GetMapping("/addPetForm")
    public String addPetForm() {
        return "addPetForm";
    }

    //Method to insert pet
    @PostMapping("/registerPet")
    public String registerPet(@RequestParam String petName, @RequestParam String species, @RequestParam String breed, @RequestParam int age, @RequestParam String description,@RequestParam String image){

        if (petName.isEmpty() || species.isEmpty() || breed.isEmpty() || description.isEmpty() || image.isEmpty()) {
            return "redirect:/addPetForm"; // Redirect back to the form page
        }
        Pet pet = new Pet(petName,  species, breed,  image,  description,  age);
        petRepository.save(pet);
        return "redirect:/addPet_success";
    }

    // Method for registering users and admin
    @PostMapping("/register")
    public String registerUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password) {
        // TO BE CONTINUED!!!!!............
        String curRole = "USER";
        User user = new User(firstName, lastName,  email,  password, curRole);

        userRepository.save(user);
        return "redirect:/login";
    }

    //Method to map login to user page or admin page
    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        // Here you would typically check if the username and password match a user in the database
        User user = userRepository.findByEmail(email);
        if (user != null && password != null) {

            if (user.getPassword().equals(password) && user.getEmail().equals(email)){

                // Check if the user is an admin
                if (user.getRole().equals("ADMIN")) {
                    return "redirect:/adminDashboard"; // Redirect to admin dashboard
                } else {
                    return "redirect:/dogs"; // Redirect to user dashboard
                }
            }else{
                return "redirect:/login_error";
            }

        } else {
            return "redirect:/login_error"; // Return login page with error message
        }
    }




    // Method to show Admin available pets
    @GetMapping("/showAdminPets")
    public String showAdminPets(Model model) {

        List<Pet> pets = petRepository.findAll();

        // Add the list of dogs to the model attribute
        model.addAttribute("pets", pets);

        // Return the name of the Thymeleaf template (HTML page) to render
        return "adminViewPets";
    }


    // Method to show User available pets
    @GetMapping("/dogs")
    public String getDogs(Model model) {

        List<Pet> pets = petRepository.findAll();

        // Add the list of dogs to the model attribute
        model.addAttribute("pets", pets);

        // Return the name of the Thymeleaf template (HTML page) to render
        return "userDashboard";
    }


    // Method to add application to the database
    @PostMapping("/adopt")
    public String submitAdoptionApplication(@RequestParam String fullName, @RequestParam String address, @RequestParam String email, @RequestParam String petName,@RequestParam String contact, @RequestParam LocalDateTime visitDateTime) {

        AdoptApplication adoptApplication = new AdoptApplication(fullName, address, email,petName, contact, visitDateTime);

        adoptionApplicationRepository.save(adoptApplication);


        return "redirect:/ApplicationSuccess";
    }


    @GetMapping("/adoptionApplications")
    public String showAdoptionApplications(Model model) {
        // Retrieve adoption applications from the database
        List<AdoptApplication> appForm = adoptionApplicationRepository.findAll();

        // Add the adoption applications as a model attribute
        model.addAttribute("applications", appForm);

        // Return the view name
        return "viewApplications";
    }

    @PostMapping("/removePet")
    public String removePetByName(HttpServletRequest request) {
        // Retrieve the pet name from the request parameters
        String petName = request.getParameter("petName");
        // Call your service method to delete the pet by name
        petService.deletePetByName(petName);
        return "redirect:/showAdminPets"; //
    }

    @PostMapping("/removeApplication")
    public String removeApplication(HttpServletRequest request) {
        // Retrieve the pet name from the request parameters
        String applicantName = request.getParameter("formId");
        // Call your service method to delete the pet by name
        applicationService.deleteAppByName(applicantName);
        return "redirect:/adoptionApplications"; //
    }
}

