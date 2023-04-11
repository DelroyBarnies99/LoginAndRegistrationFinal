package com.barnies.springboot.loginandreg.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.barnies.springboot.loginandreg.dto.UserDto;
import com.barnies.springboot.loginandreg.model.User;
import com.barnies.springboot.loginandreg.services.UserService;

@Controller
public class LoginController {

	@Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/createAccount")
    public String registrationForm(Model model) {
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "createAccount";
    }

    @PostMapping("/createAccount")
    public String registration(
            @Valid @ModelAttribute("user") UserDto userDto,
            BindingResult result,
            Model model) {
        User existingUser = userService.findUserByUsername(userDto.getUsername());

        if (existingUser != null)
            result.rejectValue("username", null,
                    "User already registered !!!");
        
        if (userDto.getPassword() == null)
        	result.rejectValue("password", null, 
        			"Please enter a valid password !!!");
        
        if (!(userDto.getConfirm_pass().equals(userDto.getPassword())))
        	result.rejectValue("confirm_pass", null, 
        			"Passwords do not match !!!");

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/createAccount";
        }

        userService.saveUser(userDto);
        //return "redirect:/registration?success";
        return "registerSuccess";
    }
}
