package com.balenii.groupi.cuddlepaw_cottage.Service;

import com.balenii.groupi.cuddlepaw_cottage.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService{

    private int userCounter = 0;

    @Autowired
    private UserRepository userRepository; // Assuming UserRepository is your JPA repository for users




}
