package com.revature.services;


import java.util.List;

import com.revature.models.User;
import com.revature.daos.UserDAO;

public class LoginService {

	public int login(String username, String password) {
		
		/*this will scan through all the users, checking that the input matches both the username and password 
		 * if any record matches exactly, it should return that user's ID
		 * Once we have the user's ID, other methods can take care of determining what role the user has
		 * if the login fails, we will return a value of -1. which should not exist in the tables, indicating that the credentials did not match
		 * */
		 
		
		UserDAO allUsers = new UserDAO();
		List<User> checkLogin = allUsers.getAllUsers();
		
		for(User test : checkLogin) {
			
			if(username.equals(test.getUserName()) && password.equals(test.getUserPassword())) {
				
				return test.getUserID();
			}
			
			
		}
		
		
		//Hardcoding user/pass because I don't want to create a whole users table to check username/password
		//Plus I have to hold your hands less as we get new projects, so I don't want to give you all the keys here
		//Typically, you'll want to validate the given username/password against some username/password in the DB.
		/*
		if(username.equals("demoMan") && password.equals("password")) {
			return true;
		}
		
		return false;
		*/
		
		return -1;
	}
		 
}
