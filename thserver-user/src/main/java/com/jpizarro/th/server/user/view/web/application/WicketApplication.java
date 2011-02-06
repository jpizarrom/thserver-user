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
import org.wicketstuff.annotation.scan.AnnotatedMountScanner;

import com.jpizarro.th.server.generic.model.service.UserService;
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
		
		/* WS */
//		mountBookmarkablePage("/ws/login", LoginWS.class);
//		mountBookmarkablePage("/ws/logout", LogoutWS.class);
//		mountBookmarkablePage("/ws/updateLocation", UpdateLocationWS.class);
//		mountBookmarkablePage("/ws/updatePersonalInfo", .class);
//		mountBookmarkablePage("/ws/register", .class);
//		mountBookmarkablePage("/ws/changePassword", .class);
//		mountBookmarkablePage("/ws/getPublicUserProfile", .class);
		
//		mountBookmarkablePage("/ws/findGameById", FindGameByIdWS.class);
//		mountBookmarkablePage("/ws/findCitiesWithGames", FindCitiesWithGamesWS.class);
//		mountBookmarkablePage("/ws/findGamesByCity", FindGamesByCityWS.class);
//		mountBookmarkablePage("/ws/findGamesByLocation", .class);
		
//		mountBookmarkablePage("/ws/findTeamById", FindTeamByIdWS.class);
//		mountBookmarkablePage("/ws/findTeamsByGame", FindTeamsByGameWS.class);
		
//		mountBookmarkablePage("/ws/joinGame", JoinGameWS.class);
//		mountBookmarkablePage("/ws/abandonGame", AbandonGameWS.class);
//		mountBookmarkablePage("/ws/GameState", GameStateWS.class);
//		mountBookmarkablePage("/ws/takePlace", TakePlaceWS.class);
		
//		mountBookmarkablePage("/ws/sendMessage", SendMessageWS.class);
//		mountBookmarkablePage("/ws/findMessages", .class);

		/* Web Pages*/
//		mountBookmarkablePage("/user/home", UserHomePage.class);
//		mountBookmarkablePage("/login", LoginPage.class);
//		mountBookmarkablePage("/register", RegisterPage.class);
		
//		mountBookmarkablePage("/createGame", .class);
//		mountBookmarkablePage("/editGame", .class);
//		mountBookmarkablePage("/gameDetails", GameDetailsPage.class);
//		mount(new MixedParamUrlCodingStrategy("gameDetails", GameDetailsPage.class,
//                new String[] {"gameId"}));

//		mountBookmarkablePage("/watchGame", .class);
//		mountBookmarkablePage("/activeGames", .class);
//		mountBookmarkablePage("/notFinishedGames", NotFinishedGamesListPage.class);
//		mountBookmarkablePage("/finishedGames", .class);

		new AnnotatedMountScanner().scanPackage("com.jpizarro.th.server").mount(this);

		
		/* Testing Web Pages*/
//		mountBookmarkablePage("/ws/game/GameTest", GameTestWS.class);
		
//		getApplicationSettings().setAccessDeniedPage(LoginPage.class);
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
//		return AnonymousHomePage.class;
		return null;
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
