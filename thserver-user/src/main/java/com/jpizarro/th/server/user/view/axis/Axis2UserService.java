package com.jpizarro.th.server.user.view.axis;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;

public interface Axis2UserService {
	void create(UserTO entity);
	
	UserTO find(Long id);
	
	boolean exists(Long id);
	
	UserTO update(UserTO entity);

	boolean remove(Long id);	
	
	
	public LoginResultTO login(String username, String password);
	
	public UserTO findUserById(Long userId);
	
}
