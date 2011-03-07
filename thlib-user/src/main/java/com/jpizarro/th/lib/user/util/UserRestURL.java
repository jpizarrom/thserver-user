package com.jpizarro.th.lib.user.util;


public class UserRestURL {

	public static final String ENTITY = "users";
	
	public static final String ENTITY_ID = "/{id}";
	
	public static final String LOGIN = "/login";
	public static final String REGISTER = "/register";
	public static final String CHANGE_PASSWORD = "/changePassword/{username}";
	public static final String UPDATE_PERSONALINFO = "/updatePersonalInfo";
	public static final String FIND_USER_BY_USERNAME = "/byUsername/{username}";

}
