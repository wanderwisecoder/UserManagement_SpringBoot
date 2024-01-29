package com.system.controller;

import org.springframework.web.bind.annotation.*;
import com.system.entities.User;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class MyController {

	@GetMapping("/")
	public String landingpage(Model model) {

		return "landingpage";

	}

	@PostMapping("/login")
	public void login(Model model) {

		model.addAttribute("userlogin", new User());

	}

	@PostMapping("/signup")
	public void signup(Model model) {
		model.addAttribute("userlogin", new User());

	}

	// handler for processing form
	@PostMapping("/process")
	public String processFormHandler(@Valid @ModelAttribute("loginData") User userlogin, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result);
			return "form";
		}
		System.out.println(userlogin);

		return "success";
	}

}
