package com.jpizarro.th.server.user.view.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.rest.GenericController;
import com.jpizarro.th.server.user.model.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController implements GenericController <UserTO, Long>{
	@Autowired
	private UserService userService;
	private String XML_VIEW_NAME = "users";
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}",
			headers="Accept=application/xml")
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
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
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
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
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
	@RequestMapping(method=RequestMethod.POST, value="")
	public UserTO addEntity(@RequestBody UserTO body) {
		// TODO Auto-generated method stub
		UserTO r = new UserTO();
		try {
			userService.create(body);
		} catch (DuplicateInstanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return r; 
		}
		try {
			r = userService.findUserByUserName(body.getUsername());
		} catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r; 
	}
}
