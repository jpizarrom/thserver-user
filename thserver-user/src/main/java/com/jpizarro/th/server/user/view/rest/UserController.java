package com.jpizarro.th.server.user.view.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.response.LoginResultTO;
import com.jpizarro.th.lib.user.entity.response.UpdatePersonalInfoTO;
import com.jpizarro.th.lib.user.entity.response.UserRegisterTO;
import com.jpizarro.th.lib.user.util.UserRestURL;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.util.ResourceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.model.service.util.exceptions.IncorrectPasswordException;

@Controller
@RequestMapping(UserRestURL.ENTITY)
public class UserController implements GenericController <UserTO, Long>{
	@Autowired
	private UserService userService;
	private String XML_VIEW_NAME = "users";
	
	@RequestMapping(method=RequestMethod.GET, value=UserRestURL.ENTITY_ID,
			headers="Accept=application/xml")
	@ResponseBody
	public UserTO getEntity(@PathVariable Long id) {
		UserTO to = null;
		try {
			to = userService.find(id);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to;
//		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"object", to);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value=UserRestURL.ENTITY_ID)
	public ModelAndView removeEntity(@PathVariable Long id) {
		boolean ret = true;
		try {
			userService.remove(id);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ret = false;
		}
		
		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"user", ret);
	}

	@Override
	public List<UserTO> getEntities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.PUT, value=UserRestURL.ENTITY_ID)
	@ResponseBody
	public UserTO updateEntity(@PathVariable Long id, @RequestBody UserTO entity) {
		// TODO Auto-generated method stub
		try {
			entity.setUserId(id);
			return userService.update(entity);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public UserTO addEntity(@RequestBody UserTO body) {
		// TODO Auto-generated method stub
		UserTO r = null;
		try {
			r = userService.create(body);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r; 
	}
	/****************************************************************************************/
	@RequestMapping(method=RequestMethod.GET, value=UserRestURL.FIND_USER_BY_USERNAME)
	@ResponseBody
	public UserTO getEntity(@PathVariable String username) {
		UserTO to = null;
		try {
			to = userService.findUserByUserName(username);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return to;
//		return new ModelAndView(XML_VIEW_NAME, BindingResult.MODEL_KEY_PREFIX+"object", to);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=UserRestURL.LOGIN)
	@ResponseBody
	public LoginResultTO login(
			@RequestParam(value="username",required=true) String username, 
			@RequestParam(value="password",required=true) String password
			){
		LoginResultTO r = null;
		try {
			r = userService.login(username, password);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		} catch (IncorrectPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		}
		return r;
	}
	
	@RequestMapping(method=RequestMethod.POST, value=UserRestURL.REGISTER)
	@ResponseBody
	public boolean register(@RequestBody UserRegisterTO body){
		boolean r = false;
		try {
			r = userService.register(body);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;	
	}
	
	@RequestMapping(method=RequestMethod.GET, value=UserRestURL.CHANGE_PASSWORD)
	@ResponseBody
	public boolean changePassword(
			@PathVariable String username, 
			@RequestParam(value="oldPassword",required=true) String oldPassword, 
			@RequestParam(value="newPassword",required=true) String newPassword
			){
		boolean r = false;
		try {
			r = userService.changePassword(username, oldPassword, newPassword);
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResourceNotFoundException();
		} catch (IncorrectPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	public boolean updatePersonalInfo(String username, 
			UpdatePersonalInfoTO updatePersonalInfoTO){
		return false;
		
	}
}
