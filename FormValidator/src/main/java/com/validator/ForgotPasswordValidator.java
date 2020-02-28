package com.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.model.ForgotPasswordForm;

@Component
public class ForgotPasswordValidator implements Validator{
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ForgotPasswordValidator.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ForgotPasswordForm forgotPasswordForm= (ForgotPasswordForm) target;
		
		final String newPassword= forgotPasswordForm.getNewPassword();
		
		final String confirmPassword= forgotPasswordForm.getConfirmPassword();
		
		final String LOWER_REGEX= "[a-z]";
		final String UPPER_REGEX= "[A-Z]"; 
		final String NUMBER_REGEX= "[A-Z]";
		final String SPECIAL_REGEX= "[ !@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]";
		
		Pattern lowerPattern= Pattern.compile(LOWER_REGEX);
		Pattern upperPattern= Pattern.compile(UPPER_REGEX);
		Pattern numberPattern= Pattern.compile(NUMBER_REGEX);
		Pattern specialPattern= Pattern.compile(SPECIAL_REGEX);
		
		if(StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(confirmPassword)) {
			errors.rejectValue("newPassword", "forgotpassword.error.message" );
		}else if(StringUtils.isNotEmpty(newPassword) && StringUtils.isNotEmpty(confirmPassword)
				&& !(StringUtils.equals(newPassword, confirmPassword)) ) {
			errors.rejectValue("newPassword", "forgot.password.notsame" );
		}else if(StringUtils.length(newPassword) < 8 || StringUtils.length(newPassword) > 16 ||
				StringUtils.length(confirmPassword) < 8 || StringUtils.length(confirmPassword) > 16) {
			errors.rejectValue("newPassword", "forgotpassword.error.message" );
		}else if( !(lowerPattern.matcher(newPassword).find()) || !(lowerPattern.matcher(confirmPassword).find()) ) {
			errors.rejectValue("newPassword", "forgotpassword.error.message" );
		}else if( !(upperPattern.matcher(newPassword)).find() || !(upperPattern.matcher(confirmPassword)).find() ) {
			errors.rejectValue("newPassword", "forgotpassword.error.message" );
		}else if( !(numberPattern.matcher(newPassword)).find() || !(numberPattern.matcher(confirmPassword)).find() ) {
			errors.rejectValue("newPassword", "forgotpassword.error.message" );
		}else if( !(specialPattern.matcher(newPassword)).find() || !(specialPattern.matcher(confirmPassword)).find() ) {
			errors.rejectValue("newPassword", "forgotpassword.error.message" );
		}
		
		/*if(StringUtils.isEmpty(newPassword) || StringUtils.isEmpty(confirmPassword)) {
			errors.rejectValue("newPassword", "forgot.password.blank" );
		}
		if(StringUtils.isNotEmpty(newPassword) && StringUtils.isNotEmpty(confirmPassword)
				&& !(StringUtils.equals(newPassword, confirmPassword)) ) {
			errors.rejectValue("newPassword", "forgot.password.notsame" );
		}
		if(StringUtils.length(newPassword) < 8 || StringUtils.length(newPassword) > 16 ||
				StringUtils.length(confirmPassword) < 8 || StringUtils.length(confirmPassword) > 16) {
			errors.rejectValue("confirmPassword", "forgot.password.length.message" );
		}*/
	}

}

















