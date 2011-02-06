package com.jpizarro.th.server.user.view.axis;

import org.springframework.beans.factory.annotation.Autowired;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;

public class WSUserService implements Axis2UserService{
	@Autowired
	private UserService userService;

	@Override
	public LoginResultTO login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			return userService.login(username, password);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IncorrectPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public UserTO findUserById(long userId) {
		// TODO Auto-generated method stub
		try {
			return userService.findUserById(userId);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
