package com.assignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(reason="User already exist",value=HttpStatus.CONFLICT)
public class UserExistException extends Exception {


	private static final long serialVersionUID = -8465082389618464247L;

	public UserExistException() {
		super();
	}
}
