package com.jpizarro.th.lib.user.util.xml.xstream;

import java.util.List;

import com.jpizarro.th.lib.generic.util.exception.THException;
import com.jpizarro.th.lib.generic.util.xml.xstream.CalendarConverter;
import com.jpizarro.th.lib.generic.util.xml.xstream.XStreamFactory;
import com.jpizarro.th.lib.user.entity.UserTO;
import com.jpizarro.th.lib.user.entity.list.UsersTO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class UserXStreamFactory implements XStreamFactory
{
	public XStream createXStream()
	{
//		XStream xstream = new XStream(new DomDriver());
		XStream xstream = new XStream(new XppDriver());
		
		xstream.registerConverter(new CalendarConverter(), XStream.PRIORITY_VERY_HIGH);
//		xstream.registerConverter(new JoinedConverter(), XStream.PRIORITY_NORMAL);

		xstream.addImplicitCollection(UsersTO.class, "users", UserTO.class);
			
//		xstream.alias("user", UserTO.class);
		xstream.processAnnotations(UserTO.class);
		
//		xstream.alias("users", List.class);
		
		xstream.alias("joined", Boolean.class);
		xstream.alias("logout", Boolean.class);
		xstream.alias("messageSent", Boolean.class);
		
		xstream.alias("exception", THException.class);
		
		return xstream;
	}

}
