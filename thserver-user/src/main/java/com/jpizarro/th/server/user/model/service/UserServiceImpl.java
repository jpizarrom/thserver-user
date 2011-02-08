package com.jpizarro.th.server.user.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.UpdatePersonalInfoTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.entity.User;
import com.jpizarro.th.server.user.model.persistence.accessor.UserAccessor;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;
import com.jpizarro.th.server.user.util.UserUtils;
import com.thoughtworks.xstream.XStream;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserAccessor userAccessor;

	@Override
	public UserTO findUserById(long userId) throws InstanceNotFoundException {
		User user = userAccessor.find(userId);
		System.out.println("IOIO : " + user);
		UserTO userTO = new UserTO();
		userTO.setUserId( user.getUserId());
		userTO.setUsername( user.getUsername());
		userTO.setPassword( user.getPassword());
//		userTO.set = user.getRole();
//		if (user.getTeam() != null && user.getTeam().getGame()!= null)
//			userTO.setGameId(user.getTeam().getGame().getGameId());
		
		userTO.setLatitude( user.getLatitude());
		userTO.setLongitude( user.getLongitude());
		
		return userTO;
	}

	@Override
	public LoginResultTO login(String username, String password)
			throws InstanceNotFoundException, IncorrectPasswordException {
		// TODO Auto-generated method stub
		User user = this.userAccessor.findByUsername(username);
		if (password .equals(user.getPassword()))
		//if (PasswordEncrypter.isClearPasswordCorrect(clearPassword, player
		//		.getUserData().getEncryptedPassword()))
			return new LoginResultTO(user);
		
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
	public boolean changePassword(String login, String oldClearPassword,
			String newClearPassword) throws InstanceNotFoundException,
			IncorrectPasswordException {
		// TODO Auto-generated method stub
		return false;
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
	public void create(UserTO entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		User user = UserUtils.teamFromTeamTO(entity);
		userAccessor.create(user);
		
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
	public UserTO update(UserTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void remove(Long id) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		userAccessor.remove(id);
		
	}

}
