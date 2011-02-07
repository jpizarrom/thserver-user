package com.jpizarro.th.lib.user.entity;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class UserTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7534948413604544467L;
	private long userId;
	private String username;
	private String password;
	//	private PersonalInformation personalInformation;
//	private long gameId;
//	private long teamId;

	private String name;
	private String description;
	private int latitude;
	private int longitude;

	private String role;

	public UserTO() {
		super();
	}

	//	public UserTO(String name, String description) {
	//		this.
	//	}
	//	public UserTO(User user) {
	//	this.userId = user.getUserId();
	//	this.username = user.getUsername();
	//	this.password = user.getPassword();
	//	this.role = user.getRole();
	//	if (user.getTeam() != null && user.getTeam().getGame()!= null)
	//		this.setGameId(user.getTeam().getGame().getGameId());
	//	
	//	this.latitude = user.getLatitude();
	//	this.longitude = user.getLongitude();
	//}

	//	public PersonalInformation getPersonalInformation() {
	//		return personalInformation;
	//	}
	//
	//	public void setPersonalInformation(PersonalInformation personalInformation) {
	//		this.personalInformation = personalInformation;
	//	}

	public String getUsername() {
		return username;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "User [userName=" + username + ", password=" + password
		+ "]";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}


}
