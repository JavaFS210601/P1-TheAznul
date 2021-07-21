package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDAO;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;

public class LoginController {

	ObjectMapper om = new ObjectMapper(); //so we can work with JSON
	private LoginService ls = new LoginService();
	private User author = new User();
	private UserDAO userDAO = new UserDAO();

	
	public void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		

		
		if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
			
			//this process below is to get our JSON String
			
			BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
			
			StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
			
			String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
			int userID;
			while(line != null) { //while there is data to read from the response data (res -> reader -> line)
				
				sb.append(line); //add the contents of "line" to the StringBuilder
				line = reader.readLine(); //assign line to the next line of data in the reader
				
				//so for every line of data that received from the response, 
				//we want to append it to the StringBuilder 
				//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!!
			}
			
			//ObjectMapper only works with Strings... (not StringBuilders...)
			String body = new String(sb); //so we make a new String to hold the StringBuilder content
			
			//Use the ObjectMapper to read our JSON username/password (which is now a Java String) 
				//remember the readValue() method of ObjectMapper turns JSON into Java
			//and put it into a LoginDTO class as fields
			LoginDTO lDTO = om.readValue(body, LoginDTO.class); //we created a LoginDTO using the JSON-turned-Java
			
			
			//control flow to determine what happens in the event of a successful/unsuccessful login--------
			
			if(ls.login(lDTO.username, lDTO.password) != -1) { //if the username/password sent to the service are valid...
				
				
				userID = ls.login(lDTO.username, lDTO.password); //get the user's ID based on username and password
				
				author = userDAO.getUserByID(userID); //get the full user object based on that ID
				
				
				String json = om.writeValueAsString(author); //convert the user object to JSON
				
				res.getWriter().print(json); //send that JSON to the front end
				
				
				HttpSession ses = req.getSession(); //return a Session to hold user info (if one doesn't exist yet)
				//remember, sessions are how you remember the different users on the client
	
				
//				
//					Cookie[] cookies = req.getCookies();
//					for (cookie : cookies) {
//						info.log(cookie);
//					}
//				
//				); //this is how I'd assume you can log cookies, getCookies returns an array
				
				//this info stays on the server, all the client gets is the request's cookie created by getSession()
				//when a user gets a session, they get a cookie returned that uniquely identifies their session
				ses.setAttribute("user", lDTO); //we'll probably just use a USer object if this was forreal
				ses.setAttribute("loggedin", true);

				
		
				res.setStatus(200); //because login was successful
				//res.getWriter().print("Hi Login was successful"); //we won't see this message anywhere but postman
				
				
			} else {
				HttpSession ses = req.getSession(false); //this will only return a session if one is already active
				
				if(ses != null) { //if a session exists...
					ses.invalidate(); //kill the session
				}
				
				res.setStatus(401); //unauthorized
				res.getWriter().print("Login Invalidated"); //we won't see this message anywhere but postman
				
					
			}
			
		}
		
		
	}

}
