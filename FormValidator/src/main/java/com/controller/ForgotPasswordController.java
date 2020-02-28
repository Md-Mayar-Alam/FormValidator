package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.ForgotPasswordForm;
import com.validator.ForgotPasswordValidator;

@Controller
public class ForgotPasswordController {

	@Autowired
	ForgotPasswordValidator forgotPasswordValidator;
	
	@RequestMapping(value="/forgotpassword", method= RequestMethod.GET)
	public String forgotPasswordPage(Model model) {
		model.addAttribute("forgotPasswordForm", new ForgotPasswordForm());
		return "forgotpassword";
	}
	
	@RequestMapping(value= "/resetPassword", method= RequestMethod.POST)
	public String check(@ModelAttribute("forgotPasswordForm") ForgotPasswordForm forgotPasswordForm, BindingResult bindingResult, Model model) {
		
		forgotPasswordValidator.validate(forgotPasswordForm, bindingResult);
		
		if (bindingResult.hasErrors()) {
			return "forgotpassword";
		}else {
			return "resetPasswordSuccess";
		}
	}
	
}
