package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.model.User;
import com.demo.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping(path = "/save")
	public String saveUser(@ModelAttribute User user, Model model) {
		userService.saveUser(user);
		model.addAttribute("user", user);
		return "successful_registration";
	}

	@PostMapping(path = "/fetch")
	public String fetchUser(@ModelAttribute User user, Model model) {
		User cUser = userService.findUserByUserName(user.getUsername());
		if (cUser != null) {
			if (user.getPassword().equals(cUser.getPassword())) {
				model.addAttribute("message", "Welcome " + cUser.getFirstName());
				return "welcome";
			} else {
				model.addAttribute("message", "Password is incorrect");
				return "welcome";
			}
		} else {
			model.addAttribute("message", "Username not found");
			return "welcome";
		}

	}

}
