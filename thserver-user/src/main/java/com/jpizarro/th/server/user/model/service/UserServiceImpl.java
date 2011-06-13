package com.jpizarro.th.server.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.lib.user.entity.response.UpdatePersonalInfoTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.entity.User;
import com.jpizarro.th.server.user.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;
import com.jpizarro.th.server.user.util.UserUtils;
import com.thoughtworks.xstream.XStream;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserAccessor userAccessor;

//	public UserTO find(long userId) throws InstanceNotFoundException {
//		User user = userAccessor.find(userId);
//		System.out.println("IOIO : " + user);
//		UserTO userTO = new UserTO();
//		userTO.setUserId( user.getUserId());
//		userTO.setUsername( user.getUsername());
//		userTO.setPassword( user.getPassword());
////		userTO.set = user.getRole();
////		if (user.getTeam() != null && user.getTeam().getGame()!= null)
////			userTO.setGameId(user.getTeam().getGame().getGameId());
//		
//		userTO.setLatitude( user.getLatitude());
//		userTO.setLongitude( user.getLongitude());
//		
//		return userTO;
//	}

	@Override
	public LoginResultTO login(String username, String password)
			throws InstanceNotFoundException, IncorrectPasswordException {
		// TODO Auto-generated method stub
		User user = this.userAccessor.findByUsername(username);
		if (password.equals(user.getPassword()))
		//if (PasswordEncrypter.isClearPasswordCorrect(clearPassword, player
		//		.getUserData().getEncryptedPassword()))
			return new LoginResultTO(user.getUserId(), user.getRole(), user.getUsername());
		
		throw new IncorrectPasswordException(username);
	}

	@Transactional
	public boolean register(UserRegisterTO usernameInfoTO)
			throws DuplicateInstanceException {
		// TODO Auto-generated method stub
//		String encryptedPassword = PasswordEncrypter.crypt(playerRegisterTO
//				.getClearPassword());
		
		User user = new User(
				usernameInfoTO.getUsername(),
				usernameInfoTO.getPassword(),
				usernameInfoTO.getEmail(),
				"ROLE_USER"
			);
		
		try {
			this.userAccessor.findByUsername(usernameInfoTO.getUsername());
		} catch (InstanceNotFoundException e) {
			this.userAccessor.create(user);
			return true;
		}
		throw new DuplicateInstanceException("User exists", User.class, "");
	}

	@Override
	@Transactional
	public boolean changePassword(String username, String oldPassword,
			String newPassword) throws InstanceNotFoundException,
			IncorrectPasswordException {
		// TODO Auto-generated method stub
		User u = userAccessor.findByUsername(username);
		if ( u.getPassword().equals(oldPassword) ){
			u.setPassword(newPassword);
			userAccessor.update(u);
			return true;
		}
		throw new IncorrectPasswordException(username);
	}

	@Override
	public boolean updatePersonalInfo(String username,
			UpdatePersonalInfoTO updatePersonalInfoTO)
			throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public UserTO create(UserTO entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		try {
			userAccessor.findByUsername(entity.getUsername());
		} catch (InstanceNotFoundException e) {
			User user = UserUtils.teamFromTeamTO(entity);
			userAccessor.create(user);
			return UserUtils.teamTOFromTeam(user);
		}
	
		throw new DuplicateInstanceException("Login exists", User.class, "");
		
	}

	@Override
	public UserTO find(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		User user = userAccessor.find(id);
		UserTO to = UserUtils.teamTOFromTeam(user);
		return to;
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return userAccessor.exists(id);
	}

	@Override
	@Transactional
	public UserTO update(UserTO entity) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		User user = UserUtils.teamFromTeamTO(entity);
		User u = userAccessor.find(entity.getUserId());
		user.setUsername(u.getUsername());
		user = userAccessor.update(user);
		UserTO to = UserUtils.teamTOFromTeam(user);
		return to;
	}

	@Override
	@Transactional
	public void remove(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		userAccessor.remove(id);
	}

	@Override
	public UserTO findUserByUserName(String username)
			throws InstanceNotFoundException {
		User user = userAccessor.findByUsername(username);
		UserTO to = UserUtils.teamTOFromTeam(user);
		return to;
	}

	@Override
	@Transactional
	public boolean updateLocation(Long arg0, int arg1, int arg2)
			throws InstanceNotFoundException {
		User user = userAccessor.find(arg0);
		
		user.setLatitude(arg1);
		user.setLongitude(arg2);
		
		userAccessor.update(user);
		return true;
	}

}
