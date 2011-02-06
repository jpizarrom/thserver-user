package com.jpizarro.th.server.view.web.application;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	private UserService userService;
	
	@Override
	@Transactional(readOnly = true)
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		
		LoginResultTO loginResultTO = null;
		try {
			loginResultTO = this.login(username, password);
		} catch (IncorrectPasswordException e) {
			throw new BadCredentialsException(e.getLocalizedMessage());
		} catch (InstanceNotFoundException e) {
			throw new BadCredentialsException(e.getLocalizedMessage());
		}

		GrantedAuthority[] grantedAuthorities = null;
		if (loginResultTO != null) {
			// TODO : take real roles from player
			List<String> roles = new ArrayList<String>();
			roles.add(loginResultTO.getRole());
			grantedAuthorities = new GrantedAuthority[roles.size()];
			for (int i = 0; i < roles.size(); i++) {
				String role = roles.get(i);
				GrantedAuthority grantedAuthority = new GrantedAuthorityImpl(
						role);
				grantedAuthorities[i] = grantedAuthority;
			}
		} else {
			throw new BadCredentialsException("Invalid login/password");
		}
		return new UsernamePasswordAuthenticationToken(loginResultTO,
				authentication.getCredentials(), grantedAuthorities);
	}
	
	private LoginResultTO login(String username, String password)
	throws InstanceNotFoundException, IncorrectPasswordException {
		return userService.login(username, password);

	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));

	}

}
