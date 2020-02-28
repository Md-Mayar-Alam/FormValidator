/**
 * 
 */

$(document).ready(function(){
	
	var password= $("#newPassword");
	var confirmPassword= $("#confirmPassword");
	var passwordInfo= $("#passwordInfo");
	var confirmPasswordInfo= $("#confirmPasswordInfo");

	hidePasswordInfo(passwordInfo);
	hidePasswordInfo(confirmPasswordInfo);
	
	password.keyup(function(){
		validate(password.val(), "password");
	}).focus(function(){
		passwordInfo.show();
	}).blur(function(){
		passwordInfo.hide();
	});
	
	confirmPassword.keyup(function(){
		validate(confirmPassword.val(), "confirmPassword");
	}).focus(function(){
		passwordInfo.show();
	}).blur(function(){
		passwordInfo.hide();
	});
	
	$("#forgotPasswordButton").click(function(){
		validateFormData(event);
	});
});

function removeInvalidAddValidClass(divElement){
	divElement.removeClass("invalid").addClass("valid");
}

function removeValidAddValidClass(divElement){
	divElement.removeClass("valid").addClass("invalid");
}

function validate(passwordData, passwordDiv){
	
	var password= false;
	var confirmPassword= false;
	
	if(passwordDiv === "password"){
		password= true;
	}else if(confirmPassword === "confirmPassword"){
		confirmPassword= true;
	}
	
	/*validation for lower case and upper case*/
	if(validateForLowerCase(passwordData) && validateForUpperCase(passwordData)){
		if(password){
			var element= $("#pwdUpperLower");
			removeInvalidAddValidClass(element);
		}else if(confirmPassword){
			var element= $("#conPwdUpperLower");
			removeInvalidAddValidClass(element);
		}
	}else{
		if(password){
			var element= $("#pwdUpperLower");
			removeValidAddValidClass(element);
		}else if(confirmPassword){
			var element= $("#conPwdUpperLower");
			removeValidAddValidClass(element);
		}
	}
	
	/*validation for length 8-16 char*/
	if(validateForLength(passwordData)){
		if(password){
			var element= $("#pwdLength");
			removeInvalidAddValidClass(element);
		}else if(confirmPassword){
			var element= $("#conPwdLength");
			removeInvalidAddValidClass(element);
		}
	}else{
		if(password){
			var element= $("#pwdLength");
			removeValidAddValidClass(element);
		}else if(confirmPassword){
			var element= $("#conPwdLength");
			removeValidAddValidClass(element);
		}
	}
	
	/*validation for 0-9 numbers*/
	if(validateForNumber(passwordData)){
		if(password){
			var element= $("#pwdLength");
			removeInvalidAddValidClass(element);
		}else if(confirmPassword){
			var element= $("#conPwdLength");
			removeInvalidAddValidClass(element);
		}
		
		removeInvalidAddValidClass(passwordDiv);
	}else{
		removeValidAddValidClass(passwordDiv);
	}
	
	/*validation for special character*/
	if(validateForSpecialCharacter(passwordData)){
		removeInvalidAddValidClass(passwordDiv);
	}else{
		removeValidAddValidClass(passwordDiv);
	}
}

function validateForLowerCase(passwordData){
	var lowerCaseRegex= /[a-z]/g;
	return passwordData.match(lowerCaseRegex) ? true : false;
}

function validateForUpperCase(passwordData){
	var upperCaseRegex= /[A-Z]/g;
	return passwordData.match(upperCaseRegex) ? true : false;
}

function validateForLength(passwordData){
	if(passwordData.length >= 8 && passwordData.length <= 16){
		return true;
	}else{
		return false;
	}
}

function validateForNumber(passwordData){
	var numberRegex= /[0-9]/g;
	return passwordData.match(numberRegex) ? true : false;
}

function validateForSpecialCharacter(passwordData){
	var specialCharRegex= /[[!@#$%^&*()_=\[\]{};':"\\|,.<>\/?+-]]/g;
	return passwordData.match(specialCharRegex) ? true : false;
}

function hidePasswordInfo(passwordInfo){
	passwordInfo.hide();
}

function validateFormData(event){
	event.preventDefault();
	/*
	
	
	if(!checkForEmpty()){
		return false;
	}*/
}













