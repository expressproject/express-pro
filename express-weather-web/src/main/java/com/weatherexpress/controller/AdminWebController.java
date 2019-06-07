package com.weatherexpress.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weatherexpress.dto.UserProfileDto;
import com.weatherexpress.dto.UserRegistrationDto;
import com.weatherexpress.service.UsersUtil;

@Controller
@RequestMapping("/admin")
public class AdminWebController {

	@Autowired
	private UsersUtil usersUtil;

	@GetMapping("/adminPage")
	public String adminPage(Model model) {
		Set<UserProfileDto> userList = usersUtil.getUsers();
		model.addAttribute("userList", userList);
		return "AdminPage";
	}

	@GetMapping("/viewUserProfile/{userName}")
	public String viewProfile(@PathVariable("userName") String userNmae, Model model) {
		UserRegistrationDto userdto = usersUtil.getUsersByUserName(userNmae);
		if (userdto != null) {
			model.addAttribute("adminView", true);
			model.addAttribute("view", true);
			model.addAttribute("messages", "Your Profile ");
			model.addAttribute("user", userdto);
		} else {
			model.addAttribute("message", "No User");
		}
		return "UserProfileViewPage";
	}
}
