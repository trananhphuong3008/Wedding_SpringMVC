/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dht.controllers;

import com.dht.pojo.User;
import com.dht.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author awmjo
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerHandler(Model model,
            @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {
        if (result.hasErrors() == true) {
            return "register";
        }

        String errMsg;
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (this.userService.addUser(user)== true)
                return "redirect:/";
            else
                errMsg="Something wrong! Please come back later!";
        } else {
            errMsg = "Password does not match!";
        }

        model.addAttribute("errMsg", errMsg);
        
        return "register";
    }
    
    @GetMapping("/login")
    public String loginView(){
        return "login";
    }
}
