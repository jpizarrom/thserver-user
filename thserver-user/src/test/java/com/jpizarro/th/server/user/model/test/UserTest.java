package com.jpizarro.th.server.user.model.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.entity.User;
import com.jpizarro.th.server.user.model.persistence.accessor.UserAccessor;

import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/app-config.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
//@TestExecutionListeners( {  TransactionalTestExecutionListener.class })
public class UserTest {
	@Autowired
	UserAccessor userAccesor;
	
	@Test
	public void testCreateAndRemove() throws DuplicateInstanceException, InstanceNotFoundException{
		User u = new User("Juan", "123", "ss@es.cl", "ROLE_USER");
		userAccesor.create(u);
		userAccesor.remove(u.getUserId());	
	}
	
	@Test
	public void testFindByUsername() throws InstanceNotFoundException, DuplicateInstanceException{
		User u = new User("Juan", "123", "ss@es.cl", "ROLE_USER");
		userAccesor.create(u);
		userAccesor.findByUsername(u.getUsername());
		
	}
	
	@Test(expected = InstanceNotFoundException.class)
	public void testInstanceNotFound() throws InstanceNotFoundException {
		User u = new User("Juans", "123", "ss@es.cl", "ROLE_USER");
		userAccesor.findByUsername(u.getUsername());
	}
	
	@Test(expected = DuplicateInstanceException.class)
	public void testDuplicateInstance() throws DuplicateInstanceException {
		User u1 = new User("Juan", "123", "ss@es.cl", "ROLE_USER");
		userAccesor.create(u1);
		
		User u2 = new User("Juan", "123", "ss@es.cl", "ROLE_USER");
		userAccesor.create(u2);
		
	}

}
