package com.login.register.login.register.controller;

import com.login.register.login.register.model.UserModel;
import com.login.register.login.register.repository.UserRepository;
import com.login.register.login.register.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
//    @GetMapping("/")
//    public String index(){
//        return "index";
//    }
    @GetMapping("/register")
    public String getregister(){
        return "register";
    }
    @GetMapping("/login")
    public String getlogin(){
        return "login";
    }
    @PostMapping("/register")
    public String register(UserModel userModel, @RequestBody String name, String email, String password,Model model){
        if(userRepository.findByEmail(email)!=null){
            System.out.println("email exist");
            model.addAttribute("messages","Email exist");
            return "register";
        }else{
             userService.save(userModel);
            System.out.println("save");}
        return "login";
    }
//    @PostMapping("/login")
//    public String login(@RequestBody UserModel userModel) {
//        String email = userModel.getEmail();
//        String password = userModel.getPassword();
//        userService.isValidUser(email,password);
//    return "welcome";
//    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password,UserModel userModel,Model model) {
        if (userService.isValidUser(email, password)) {

            model.addAttribute("name",userModel.getEmail());
           // System.out.println(userModel.getName());

            return "login_sucsses";
        } else {
            return "login_failed";
        }
    }
//    @PostMapping("/login")
//    public String login(@RequestBody UserModel userModel){
//        String email=userModel.getEmail();
//        String password=userModel.getPassword();
//        if(userService.isValidUser(email,password)){
//            return"login_sucsses";
//        }else{
//            return"login_failed";
//        }
    }
//}
