package com.balenii.groupi.cuddlepaw_cottage.Repository;

import com.balenii.groupi.cuddlepaw_cottage.Entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role,String> {

    Role findByRole(String role);
}
