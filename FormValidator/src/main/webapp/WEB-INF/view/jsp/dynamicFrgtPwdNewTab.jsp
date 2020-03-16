<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<script type="text/javascript" src="js/jQuery/3.4.0/jquery.min.js"></script>
		<script type="text/javascript" src="js/dynamicFrgtPwdNewTab.js"></script>
		<link rel="stylesheet" href="css/dynamicFrgtPwdNewTab.css">
	</head>
	
	<body>
		<div id="forgotPasswordPopup" class="frgt-pwd-container">
			<div class="frgt-pwd-inner-container">
				<div class="auth-require-fields">
					<form:form action="/dynamicFrgtPwdNewTab" method="post" modelAttribute="forgotPasswordForm">
						<h1>
							Create new password
						</h1>
						<p class="ask-pwd-para" >We will ask for this password whenever you sign in.</p>
						
						<div class="password-section">
							<label for="newPassword" class="password-label">
								<spring:message code="forgotpassword.newpassword"></spring:message>
							</label>
							<form:password path="newPassword" class="input-password"></form:password>
							<form:errors path="newPassword" class="error-message"></form:errors>	
						</div>
						
						<div class="password-section">
							<label for="confirmPassword" class="password-label">
								<spring:message code="forgotpassword.confirmpassword"></spring:message>
							</label>
							<form:password path="confirmPassword" class="input-password"></form:password>	
							<form:errors path="confirmPassword" class="error-message"></form:errors>
						</div>
						
						<div class="submit-section">
							<button id="saveButton" class="submit-section-button" type="submit">
								<spring:message code="forgot.password.submit-button-text"></spring:message>
							</button>
						</div>
						
						<div class="cancel-section">
							<button id="cancelButton" class="submit-section-button">
								<spring:message code="forgot.password.cancel-button-text"></spring:message>
							</button>
						</div>
						
						<div id="forgotPasswordError" class="hide error-message">
							<spring:message code="forgotpassword.error.message"></spring:message>
						</div>
					</form:form>
				</div>
				
				<div id="passwordInfo" class="password-tips">
					<h4 class="password-info-header">
						<spring:message code="forgot.password.password-must-include"></spring:message>
					</h4>
					
						<ul>
							<li>
								<spring:message code="forgot.password.must-same"></spring:message>
							</li>
							<li>
								<spring:message code="forgot.password.both-upper-and-lower-case-letter"></spring:message>
							</li>
							<li>
								<spring:message code="forgot.password.between-8-16"></spring:message>
							</li>
							<li>
								<spring:message code="forgot.password.a-number"></spring:message>
							</li>
							<li>
								<spring:message code="forgot.password.one-special-character"></spring:message>
							</li>
						</ul>
				</div>	
			</div>
		</div>
	</body>
</html>