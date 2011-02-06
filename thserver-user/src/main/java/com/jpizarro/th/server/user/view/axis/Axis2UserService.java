package com.jpizarro.th.server.user.view.axis;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.view.axis.GenericService;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;

public interface Axis2UserService extends GenericService <UserTO>{
	public LoginResultTO login(String username, String password);
	
	public UserTO findUserById(long userId);
}
