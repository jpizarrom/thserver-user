package com.jpizarro.th.server.user.view.axis;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;

@WebService(serviceName="UserService")
@SOAPBinding(style=SOAPBinding.Style.RPC)
public class Axis2UserServiceImpl implements Axis2UserService {
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
	public UserTO findUserById(Long userId) {
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
	public void create(UserTO entity) {
		// TODO Auto-generated method stub
		try {
			userService.create(entity);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserTO find(Long id) {
		// TODO Auto-generated method stub
		try {
			return userService.find(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return userService.exists(id);
	}

	@Override
	public UserTO update(UserTO entity) {
		// TODO Auto-generated method stub
		return userService.update(entity);
	}

	@Override
	public boolean remove(Long id) {
		// TODO Auto-generated method stub
		try {
			userService.remove(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

}
