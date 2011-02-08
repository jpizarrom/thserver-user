package com.jpizarro.th.server.user.view.axis;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.axis.GenericService;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;

public interface Axis2UserService {
	void create(UserTO entity) throws DuplicateInstanceException;
	
	UserTO find(Long id) throws InstanceNotFoundException;
	
	boolean exists(Long id);
	
	UserTO update(UserTO entity);

	boolean remove(Long id) throws InstanceNotFoundException;	
	
	
	public LoginResultTO login(String username, String password);
	
	public UserTO findUserById(Long userId);
	
}
