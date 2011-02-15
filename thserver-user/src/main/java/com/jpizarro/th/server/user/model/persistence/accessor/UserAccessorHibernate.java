package com.jpizarro.th.server.user.model.persistence.accessor;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jpizarro.th.server.generic.model.persistence.accessor.GenericAccessorHibernate;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.entity.User;


public class UserAccessorHibernate extends GenericAccessorHibernate<User, Long> 
implements UserAccessor {

	public User findByUsername(String username) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		User user = (User)getSession().createQuery(
				"SELECT p " +
				"FROM User p " +
				"WHERE username = :username").setParameter(
						"username", username).uniqueResult();
		if (user == null) {
			throw new InstanceNotFoundException(username, User.class
					.getName());
		}
		return user;
	}

	@Override
	public void create(User entity) throws DuplicateInstanceException {
		// TODO Auto-generated method stub
		try {
			this.findByUsername(entity.getUsername());
			throw new DuplicateInstanceException(entity, User.class.getName());
		} catch (InstanceNotFoundException e) {
			super.create(entity);
		}
		
	}

//	public List<User> findOrderedByPoints(int startIndex, int count) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
