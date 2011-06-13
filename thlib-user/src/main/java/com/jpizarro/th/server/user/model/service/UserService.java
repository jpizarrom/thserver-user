package com.jpizarro.th.server.user.model.service;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.lib.user.entity.response.UpdatePersonalInfoTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.model.service.GenericService;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;

public interface UserService extends GenericService <UserTO, Long>{
//	public UserTO findUserById(long userId) throws InstanceNotFoundException;
	public UserTO findUserByUserName(String username) throws InstanceNotFoundException;
	
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
	
	public boolean updateLocation(Long id, 
			int latitude, int longitude)
		throws InstanceNotFoundException;

}
