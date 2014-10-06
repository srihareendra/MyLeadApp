package com.javachap.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.javachap.domain.User;
import com.javachap.service.UserService;

public class UserServiceImpl extends ServiceImpl implements UserService {

	private static final long serialVersionUID = 4889152297004460837L;

	List<User> userList= new ArrayList<User> ();
	
	/**
	 * Singleton Instance of UserServiceImpl
	 */
	private static UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	/**
	 * Creates Instance of {@link UserServiceImpl}
	 */
	private UserServiceImpl(){		
	}
	
	/***
	 * Gets Instance of UserService
	 * @return UserService Implementation
	 */
	public static UserService getInstance(){	
		return userServiceImpl;
	}

	public User authenticate(String email, String password) {
		User user = null;
 
		return user;
	}

	public User getUser(Long userId) {
		System.out.println("UserServiceImpl:getUser entered ...userId = "+userId);
		User user = null;
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()){
			user= (User)iterator.next();
			if(user!=null){
				if(user.getId().longValue()==userId.longValue()){
					break;
				}
				user = null;
			}			
		}
		return user;
	}

	public User save(User user) {
		System.out.println("UserServiceImpl:save entered ...user to save = "+user);
		userList.add(user);
		return user;		
	}
}
