package com.grailsrocks.authentication

import grails.validation.Validateable;

@Validateable
class LoginForm implements Serializable {
    String email
    String password

    boolean rememberMe

    static constraints = {
        email(email:true, nullable: true, blank: false)
        password(size:6..40, password:true, nullable: false, blank:false)
    }
}
