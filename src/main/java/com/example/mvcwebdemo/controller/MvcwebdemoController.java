package com.example.mvcwebdemo.controller;

import com.example.mvcwebdemo.model.RegistrationForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MvcwebdemoController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("registrationForm", new RegistrationForm());
        return "registration";
    }

    @PostMapping("/register")
    public String handleRegistration(
            @Valid @ModelAttribute("registrationForm") RegistrationForm registrationForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        model.addAttribute("firstName", registrationForm.getFirstName());
        model.addAttribute("lastName", registrationForm.getLastName());
        model.addAttribute("country", registrationForm.getCountry());
        model.addAttribute("dob", registrationForm.getDob());
        model.addAttribute("email", registrationForm.getEmail());
        return "success";
    }
}
