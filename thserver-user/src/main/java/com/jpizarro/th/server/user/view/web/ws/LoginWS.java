package com.jpizarro.th.server.user.view.web.ws;

import org.apache.wicket.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

//import com.jpizarro.th.lib.game.entity.GameTO;
import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.util.xml.xstream.UserXStreamFactory;
//import com.jpizarro.th.server.game.model.service.GameService;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.generic.model.service.UserService;
import com.jpizarro.th.server.generic.view.web.ws.util.GenericWS;
//import com.jpizarro.th.server.generic.view.web.ws.util.GenericWS;
import com.jpizarro.th.server.user.model.service.to.LoginResultTO;
import com.jpizarro.th.server.user.view.web.application.WicketApplication;
import com.jpizarro.th.server.user.view.web.session.WicketSession;
import com.thoughtworks.xstream.XStream;

@MountPath(path = "/ws/login")
public class LoginWS extends GenericWS {

	public LoginWS(PageParameters parameters) {
		super(parameters, new UserXStreamFactory());
		// TODO Auto-generated constructor stub
	}

	public void	doExecute(PageParameters parameters){

		final String login = parameters.getString("login");
		final String clearPassword = parameters.getString("password");

		WicketSession session = WicketSession.get();
//		GameService gameService = WicketApplication.get().getGameService();
		UserService userService = WicketApplication.get().getUserService();
//		GameTO gTO = null;
		UserTO uTO = null;

		if (session.signIn(login, clearPassword)){
			System.out.println("session.signIn");
			session.bind();
			LoginResultTO loginResultTO = session.getLoginResultTO();
			
			try {
//				gTO = gameService.findGameById(userService.findUserById(loginResultTO.getUserId()).getGameId());
				uTO = userService.findUserById(loginResultTO.getUserId());
			} catch (InstanceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			XStream xf = xStreamFactory.createXStream();
			this.selement = xf.toXML(uTO);
//			this.element = TOToXMLConversor.toXML(uTO);
//			this.element = TOToXMLConversor.toXML(loginResultTO);
//			if( gTO!= null )
//				this.element.addContent(TOToXMLConversor.toXML(gTO));
		}else{
			System.out.println("not session.signIn");
		}
	}
}
