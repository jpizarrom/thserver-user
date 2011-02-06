package com.jpizarro.th.server.user.view.axis;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;

@WebService(serviceName="MyService", targetNamespace="http://test")
public class WSUserService extends SpringBeanAutowiringSupport implements Axis2UserService {
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
	@WebMethod
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

	@Override
	public void create(UserTO entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserTO find(long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return userService.find(id);
	}
	public UserTO getWSUser(long id) throws InstanceNotFoundException{
		return find(id);
		
	}

	@Override
	public boolean exists(long id) {
		// TODO Auto-generated method stub
		return userService.exists(id);
	}

	@Override
	public UserTO update(UserTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		userService.remove(id);
		
	}

}
