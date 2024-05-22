package com.balenii.groupi.cuddlepaw_cottage.Repository;

import com.balenii.groupi.cuddlepaw_cottage.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Optional;
@EnableMongoRepositories
public interface UserRepository extends MongoRepository<User,String> {

    User findByEmail(String email);
}
