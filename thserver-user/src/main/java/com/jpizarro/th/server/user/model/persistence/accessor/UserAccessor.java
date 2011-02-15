package com.jpizarro.th.server.user.model.persistence.accessor;

import java.util.List;

import com.jpizarro.th.server.generic.model.persistence.accessor.GenericAccessor;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.DuplicateInstanceException;
import com.jpizarro.th.server.generic.model.persistence.util.exceptions.InstanceNotFoundException;
import com.jpizarro.th.server.user.model.entity.User;

public interface UserAccessor 
	extends GenericAccessor<User, Long> {

	public User findByUsername(String username) throws InstanceNotFoundException;
	
//	public List<User> findOrderedByPoints(int startIndex, int count);
}
