package com.jpizarro.th.server.user.util;

import java.util.ArrayList;
import java.util.List;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.user.model.entity.User;

public class UserUtils {

	public static UserTO teamTOFromTeam(User u) {
		UserTO to = new UserTO();
		
		to.setUserId( u.getUserId());
		to.setUsername( u.getUsername());
		to.setPassword( u.getPassword());
		
		
		
		to.setRole( u.getRole());
		
		to.setLatitude( u.getLatitude());
		to.setLongitude( u.getLongitude());

		to.setName( u.getName());
		
		return to;
	}
	public static User teamFromTeamTO(UserTO to) {
		User u = new User();
		
		u.setName(to.getName());
		
		return u;
	}
}
