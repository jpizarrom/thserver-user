package com.jpizarro.th.server.user.view.web.application;

import org.apache.wicket.Application;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.authentication.AuthenticatedWebApplication;
import org.apache.wicket.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebRequestCycleProcessor;
import org.apache.wicket.protocol.http.request.CryptedUrlWebRequestCodingStrategy;
import org.apache.wicket.protocol.http.request.WebRequestCodingStrategy;
import org.apache.wicket.request.IRequestCodingStrategy;
import org.apache.wicket.request.IRequestCycleProcessor;
import org.apache.wicket.request.target.coding.MixedParamUrlCodingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jpizarro.th.server.user.model.service.UserService;
import com.jpizarro.th.server.user.view.web.pages.BasePage;
import com.jpizarro.th.server.user.view.web.session.WicketSession;

/**
 * Application object for your web application. If you want to run this application without deploying, run the Start class.
 */
@Component
public class WicketApplication extends AuthenticatedWebApplication
{ 
	@Autowired
	private UserServiceAuthenticationManager userServiceAuthenticationManager;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private GameService gameService;
		
    /**
     * Constructor
     */
	public WicketApplication()
	{
		super();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		super.init();
		/*
         * Remove wicket tags from result HTML
         */
        getMarkupSettings().setStripWicketTags(true);
	}

	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<? extends WebPage> getHomePage()
	{
//		WicketSession session = WicketSession.get();
//		if (session.isSignedIn() && !session.isSessionInvalidated()) {
//			for (String role : session.getRoles()) {
//				if (role.equals("ROLE_ADMIN"))
//					return HomePage.class;
//				if (role.equals("ROLE_USER"))
//					return UserHomePage.class;
//			}
//		}
		return BasePage.class;
	}
	
	@Override
	public Session newSession(Request request, Response response) {
	
		return new WicketSession(request);
	}
	
//	@Override
//	protected IRequestCycleProcessor newRequestCycleProcessor() {
//
//		return new WebRequestCycleProcessor() {
//			@Override
//			protected IRequestCodingStrategy newRequestCodingStrategy() {
//				return new CryptedUrlWebRequestCodingStrategy(new WebRequestCodingStrategy());
//			}
//		};
//	}
	
	public static WicketApplication get() {
        return (WicketApplication) Application.get();
    }

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		// TODO Auto-generated method stub
//		return AnonymousHomePage.class;
		return null;
	}

	@Override
	protected Class<? extends AuthenticatedWebSession> getWebSessionClass() {
		// TODO Auto-generated method stub
		return WicketSession.class;
	}
	
	public UserService getUserService() {
		return userService;
	}

//	public GameService getGameService() {
//		return gameService;
//	}

	public UserServiceAuthenticationManager getUserServiceAuthenticationManager() {
		return userServiceAuthenticationManager;
	}

}
