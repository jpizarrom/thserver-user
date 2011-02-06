package com.jpizarro.th.server.user.model.service;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.UpdatePersonalInfoTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;

public interface UserService {
	public UserTO findUserById(long userId) throws InstanceNotFoundException;
	
	public LoginResultTO login(String username, String password)
	throws InstanceNotFoundException, IncorrectPasswordException;
	
	public boolean register(UserRegisterTO userInfoTO)
	throws DuplicateInstanceException;
	
	public boolean changePassword(String login, String oldClearPassword, 
			String newClearPassword)
		throws InstanceNotFoundException, IncorrectPasswordException;
	
	public boolean updatePersonalInfo(String username, 
			UpdatePersonalInfoTO updatePersonalInfoTO)
		throws InstanceNotFoundException;

}
