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
public class DynamicLinkNewTabController {

	@Autowired
	ForgotPasswordValidator forgotPasswordValidator;
	
	@GetMapping("/dynamicPopup")
	public String dynamicPopup(Model model) {
		model.addAttribute("forgotPasswordForm", new ForgotPasswordForm());
		
		return "dynamicPopup";
	}
	
	@GetMapping("/dynamicFrgtPwdNewTab")
	public String dynamicPopupLink(Model model) {
		model.addAttribute("forgotPasswordForm", new ForgotPasswordForm());
		model.addAttribute("containsError", false);
		return "dynamicFrgtPwdNewTab";
	}
	
	@PostMapping("/dynamicFrgtPwdNewTab")
	public String dynamicFrgtPwdPopup(@ModelAttribute("forgotPasswordForm")ForgotPasswordForm forgotPasswordForm,
			BindingResult bindingResult, Model model) {
		
		forgotPasswordValidator.validate(forgotPasswordForm, bindingResult);
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("containsError", true);
			return "forgotPasswordPopup";
		}
		return "resetPasswordSuccess";
	}
}
