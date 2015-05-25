package com.catalyst.sample.services;


import com.catalyst.sample.exception.InvalidUserException;
import com.catalyst.sample.model.SignUpForm;

public interface SampleService {
	public SignUpForm saveFrom(SignUpForm signUpForm) throws InvalidUserException;

}
