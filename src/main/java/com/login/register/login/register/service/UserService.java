package com.login.register.login.register.service;

import com.login.register.login.register.model.UserModel;
import com.login.register.login.register.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserModel save(UserModel userModel){

        return userRepository.save(userModel);
    }
    public boolean isValidUser(String email, String password) {
        Optional<UserModel> optionalUser = userRepository.findByEmailAndPassword(email,password);

        if (optionalUser.isPresent()) {
            UserModel userModel = optionalUser.get();
            userModel.getPassword().equals(password);
            userModel.getName();
        }else{
        return false;}
        return true;
    }
}


