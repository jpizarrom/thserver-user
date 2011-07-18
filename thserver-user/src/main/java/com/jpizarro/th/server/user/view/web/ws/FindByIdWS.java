package com.jpizarro.th.server.user.view.web.ws;

import org.apache.wicket.PageParameters;

import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.util.xml.xstream.UserXStreamFactory;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.view.web.ws.util.GenericWS;
import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.view.web.application.WicketApplication;
import com.thoughtworks.xstream.XStream;

//@MountPath(path = "/ws/findById")
//@MountMixedParam(parameterNames={"userId"})
public class FindByIdWS extends GenericWS {

	public FindByIdWS(PageParameters parameters) {
		super(parameters, new UserXStreamFactory());
		// TODO Auto-generated constructor stub
	}

	public void	doExecute(PageParameters parameters){
		long teamId = parameters.getLong("userId");
		
		UserService service = WicketApplication.get().getUserService();
		try {
			UserTO teamTO = service.find(teamId);
			
			XStream xf = xStreamFactory.createXStream();
			this.selement = xf.toXML(teamTO);
//			this.element = TOToXMLConversor.toXML(teamTO);
		} catch (InstanceNotFoundException e) {
			System.out.println("IOIO : " + e.getMessage());
		}
	}

}
