package com.catalyst.sample.services;

import com.catalyst.sample.model.SignUpForm;
import com.catalyst.sample.dao.UserDao;
import com.catalyst.sample.dao.model.User;
import com.catalyst.sample.exception.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


public class SampleServiceImpl {
	@Autowired
    UserDao userDao;

    public SignUpForm saveFrom(SignUpForm signupForm) throws InvalidUserException{

        String firstName = signupForm.getFirstName();

        if(!StringUtils.isEmpty(firstName) && "Dave".equalsIgnoreCase(firstName)) {
            throw new InvalidUserException("Sorry Dave");
        }


        // Shown for example, you could use a constructor, builder pattern or Dozer
        // point is that the DAO only knows and cares about users and not any UI form.
        User user = new User();
        user.setFirstName(signupForm.getFirstName());
        user.setEmail(signupForm.getEmail());
        user.setLastName(signupForm.getLastName());

        user = userDao.save(user);

        signupForm.setId(user.getId());

        return signupForm;

    }

	

}
