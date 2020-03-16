/**
 * javascript file for forgotpassword.jsp
 */

$(document).ready(function(){
	$("#forgotPasswordButton").click(function(){
		var password= $("#newPassword");
		var confirmPassword= $("#confirmPassword");
		
		var isValid= validateFormData(event, password.val(), confirmPassword.val());
		if(isValid){
			$("#forgotPasswordForm").submit();
		}else{
			$("#forgotPasswordError").removeClass("hide");
			password.val("");
			confirmPassword.val("");
			return false;
		}
	});
});

function validateFormData(event, password, confirmPassword){
	event.preventDefault();
	
	if(validateForEmpty(password, confirmPassword)){
		return false;
	}
	
	if(!validateForLength(password) || !validateForLength(confirmPassword)){
		return false;
	}
	
	if(!validateForSame(password, confirmPassword)){
		return false;
	}
	
	if(!validateForLowerCase(password) || !validateForLowerCase(confirmPassword)){
		return false;
	}
	
	if(!validateForUpperCase(password) || !validateForUpperCase(confirmPassword)){
		return false;
	}
	
	if(!validateForNumber(password) || !validateForNumber(confirmPassword)){
		return false;
	}
	
	if(!validateForSpecialCharacter(password) || !validateForSpecialCharacter(confirmPassword)){
		return false;
	}
	
	return true;
}

function validateForEmpty(password, confirmPassword){
	if(password.length == 0 || confirmPassword.length == 0){
		return true;
	}else{
		return false;
	}
}

function validateForLength(passwordData){
	if(passwordData.length >= 8 && passwordData.length <= 16){
		return true;
	}else{
		return false;
	}
}

function validateForSame(password, confirmPassword){
	return password === confirmPassword ? true : false;
}

function validateForLowerCase(passwordData){
	var lowerCaseRegex= /[a-z]/g;
	return passwordData.match(lowerCaseRegex) ? true : false;
}

function validateForUpperCase(passwordData){
	var upperCaseRegex= /[A-Z]/g;
	return passwordData.match(upperCaseRegex) ? true : false;
}

function validateForNumber(passwordData){
	var numberRegex= /[0-9]/g;
	return passwordData.match(numberRegex) ? true : false;
}

function validateForSpecialCharacter(passwordData){
	//var specialCharRegex= /[[!@#$%^&*()_=\[\]{};':"\\|,.<>\/?+-]]/g;
	var specialCharRegex= /[ !@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]/;
	return passwordData.match(specialCharRegex) ? true : false;
}
















