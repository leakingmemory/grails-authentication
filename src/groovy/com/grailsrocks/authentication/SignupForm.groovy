package com.grailsrocks.authentication

import grails.validation.Validateable;

@Validateable
class SignupForm implements Serializable {
	String login
	String email
	String password
	String passwordConfirm
	
	boolean rememberMe
	
	def authenticationService
	
	static constraints = {
		login(size:6..40, blank:false, nullable: false, validator: { val, obj -> obj.authenticationService.checkLogin(val) })
		email(email:true, size:6..40, blank:false, nullable: false)
		password(size:6..40, password:true, blank:false, nullable: false, validator: { val, obj -> obj.authenticationService.checkPassword(val) })
		passwordConfirm(password:true, validator: { val, obj -> obj.password == val })
	}
}
