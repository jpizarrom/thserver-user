package com.jpizarro.th.server.user.model.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.server.user.model.persistence.accessor.UserAccessor;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:/spring/app-config.xml" })
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/app-config.xml")

@Transactional
public class UserTest {
	@Autowired
	UserAccessor userAccesor;
	
	@Test
	public void testCreateAndRemove(){
	}

}
