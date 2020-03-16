package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.model.LoginForm;

@Controller
public class BootstrapModalPopupController {

	@GetMapping("/loginModalForm")
	public String getLoginModalPage(Model model) {
		
		model.addAttribute("loginForm", new LoginForm());
		
		return "loginModalForm";
	}
}
