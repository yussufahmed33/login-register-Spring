package com.login.register.login.register.repository;

import com.login.register.login.register.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    Optional<UserModel> findByEmailAndPassword(String email,String password);

     UserModel findByEmail(String email);
     UserModel findByName(String name);

}
