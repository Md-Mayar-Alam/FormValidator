package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.ForgotPasswordForm;
import com.validator.ForgotPasswordValidator;

@Controller
public class ForgotPasswordPopupController {

	@Autowired
	ForgotPasswordValidator forgotPasswordValidator;
	
	@GetMapping("/fogotPasswordPopup")
	public String fogotPasswordPopup(Model model) {
		
		model.addAttribute("forgotPasswordForm", new ForgotPasswordForm());
		model.addAttribute("containsError", false);
		return "forgotpasswordpopup";
	}
	
	@GetMapping("/fogotPasswordPopup2")
	public String fogotPasswordPopup2() {
		return "forgotpasswordpopup2";
	}
	
	@PostMapping("/resetPwdPopup")
	public String resetForgotPwdPopup(@ModelAttribute("forgotPasswordForm")ForgotPasswordForm forgotPasswordForm,
										BindingResult bindingResult, Model model) {
		forgotPasswordValidator.validate(forgotPasswordForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("containsError", true);
			return "forgotpasswordpopup";
		}
		return "resetPasswordSuccess";
	}
}
