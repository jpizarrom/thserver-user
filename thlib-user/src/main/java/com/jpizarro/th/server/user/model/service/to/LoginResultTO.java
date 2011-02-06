package com.jpizarro.th.server.user.model.service.to;

import java.io.Serializable;

import com.jpizarro.th.server.user.model.entity.User;

public class LoginResultTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7666221931319488807L;
	private long userId;
	private String role;
	private String username;
	
	public LoginResultTO(String role, String username) {
		super();
		this.role = role;
		this.username = username;
	}
	public LoginResultTO(User user) {
		this.setUserId(user.getUserId());
		this.username = user.getUsername();
		this.role = user.getRole();
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getUserId() {
		return userId;
	}
	
	

}
