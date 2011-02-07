package com.jpizarro.th.server.user.view.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	private String XML_VIEW_NAME = "users";
	
	@RequestMapping(method=RequestMethod.GET, value="/users/{id}")
	public UserTO getEmployee(@PathVariable String id) {
		UserTO to = null;
		try {
			to = userService.find(Long.parseLong(id));
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


}
