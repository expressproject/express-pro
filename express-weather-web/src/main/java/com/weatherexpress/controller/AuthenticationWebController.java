package com.weatherexpress.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weatherexpress.dto.UserRegistrationDto;
import com.weatherexpress.entity.Users;
import com.weatherexpress.service.UsersUtil;

@Controller
public class AuthenticationWebController {
	@Autowired
	private UsersUtil usersUtil;

	@RequestMapping(value = "/")
	public String defaultPage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("messages", "Hi " + auth.getName().toUpperCase() + " Welcome to Express Pro");
		return "welcome";
	}

	@RequestMapping(value = "/welcome")
	public String welcomePage(Model model) {
		return "welcome";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "customLoginPage";
	}

	@RequestMapping(value = "/logout")
	public String logoutPage(Model model, HttpServletRequest req, HttpServletResponse res) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, res, auth);
			model.addAttribute("messages", "Logout successfully");
		}
		return "welcome";
	}

	@RequestMapping(value = "/userPost")
	public String userPost(HttpServletRequest req) {
		System.out.println(req);
		return "userPosts";
	}

	@GetMapping("/userRegistration")
	public String personForm(Model model) {
		model.addAttribute("userProfile", new UserRegistrationDto());
		return "userRegistrationPage";
	}

	@PostMapping("/registerUser")
	public String personSubmit(@ModelAttribute("userProfile") UserRegistrationDto user, Model model,
			BindingResult bindingResult) throws IOException {
		// save the user
		System.out.println(user);
		if (!bindingResult.hasErrors()) {
			model.addAttribute("user", user);
			model.addAttribute("update", true);
			return "UserProfileViewPage";
		}
		return "userRegistrationPage";
	}

	@GetMapping("/viewProfile/{userName}")
	public String viewProfile(@PathVariable("userName") String userName, Model model) {

		Users user = usersUtil.getUsersByUserName("ravikumar");
		if (user != null) {
			UserRegistrationDto userdto = new UserRegistrationDto();
			userdto.setFirstName(user.getFirstName());
			userdto.setLastName(user.getLastName());
			model.addAttribute("view", true);
			model.addAttribute("messages", "Your Profile ");
			model.addAttribute("user", userdto);
		} else {
			model.addAttribute("message", "No User");
		}
		return "UserProfileViewPage";
	}

	@GetMapping("/editProfile/{userName}")
	public String editProfile(@ModelAttribute("userProfile") UserRegistrationDto user,
			@PathVariable("userName") String userName, Model model) {
		Users existuser = usersUtil.getUsersByUserName("ravikumar");
		user.setFirstName(existuser.getFirstName());
		user.setLastName(existuser.getLastName());
		return "userRegistrationPageEdit";
	}
}
