package com.jpizarro.th.server.user.view.web.ws;

import org.apache.wicket.PageParameters;
import org.wicketstuff.annotation.mount.MountPath;

import com.jpizarro.th.lib.user.util.xml.xstream.UserXStreamFactory;
import com.jpizarro.th.server.generic.view.web.ws.util.GenericWS;
import com.jpizarro.th.server.user.view.web.session.WicketSession;
import com.thoughtworks.xstream.XStream;

@MountPath(path = "/ws/logout")
public class LogoutWS extends GenericWS {
	public LogoutWS(PageParameters parameters) {
		super(parameters, new UserXStreamFactory());
		// TODO Auto-generated constructor stub
	}

	public void	doExecute(PageParameters parameters){
		
		WicketSession.get().signOut();
	
//		this.element = TOToXMLConversor.toXML(TOToXMLConversor.OK_LOGOUT_ELEMENT_NAME);
		XStream xf = xStreamFactory.createXStream();
		this.selement = xf.toXML(true);
		
//		try {
//			ServletUtils.writeServiceResponse(
//					TOToXMLConversor.toXML(TOToXMLConversor.OK_LOGOUT_ELEMENT_NAME), this.getResponse());
//		} catch (Exception e) {
//			try {
//				ServletUtils.writeServiceResponse(TOToXMLConversor.toXML(e,
//						ExceptionCodes.GENERAL_CODE), this.getResponse());
//			} catch (IOException io) {				
//				System.out.println("IOIO : " + e.getMessage());			
//			}
//		}
	}

}
