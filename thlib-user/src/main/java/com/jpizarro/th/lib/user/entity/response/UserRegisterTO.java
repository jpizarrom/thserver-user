package com.jpizarro.th.lib.user.entity.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("userregister")
public class UserRegisterTO {
	private String username;
	private String password;
	private String email;
	private String phone;
	private String name;
	private String surname;
	private String country;
	private boolean showPersonalInfo;
	
	public UserRegisterTO(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public UserRegisterTO(String username, String password, String email,
			String phone, String name, String surname, String country,
			boolean showPersonalInfo) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.surname = surname;
		this.country = country;
		this.showPersonalInfo = showPersonalInfo;
	}
	public String getUsername() {
		return username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isShowPersonalInfo() {
		return showPersonalInfo;
	}
	public void setShowPersonalInfo(boolean showPersonalInfo) {
		this.showPersonalInfo = showPersonalInfo;
	}
	
	
}
