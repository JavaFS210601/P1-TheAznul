package com.revature.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.UserDAO;
import com.revature.models.LoginDTO;
import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementDTO;
import com.revature.models.User;
import com.revature.services.LoginService;

public class ReimbursementController {	
	
	ObjectMapper om = new ObjectMapper(); //so we can work with JSON
private LoginService ls = new LoginService();
private User author = new User();
private UserDAO userDAO = new UserDAO();
private ReimbursementDAO reimbDao = new ReimbursementDAO();
private Reimbursement reimb = new Reimbursement();


public void addItem(HttpServletRequest req, HttpServletResponse res) throws IOException {
	

	
	if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
		//this process below is to get our JSON String
		
		BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
		
		StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
		
		String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
		
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
		Reimbursement lDTO = om.readValue(body, Reimbursement.class); //we created a ReimbursementDTO using the JSON-turned-Java
		
		reimbDao.newReimbursement(lDTO);
		
		
		res.setStatus(200);
		
	
		
	}
	
	
}

public void myReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
List<Reimbursement> myTickets = new ArrayList<>();
	
	if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
		//this process below is to get our JSON String
		
		BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
		
		StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
		
		String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
		
		while(line != null) { //while there is data to read from the response data (res -> reader -> line)
			
			sb.append(line); //add the contents of "line" to the StringBuilder
			line = reader.readLine(); //assign line to the next line of data in the reader
			
			//so for every line of data that received from the response, 
			//we want to append it to the StringBuilder 
			//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!!
		}
		
		String body = new String(sb); //so we make a new String to hold the StringBuilder content
		
		author = om.readValue(body, User.class);
		
		myTickets = reimbDao.getReimbursementByUser(author);
		
		String json = om.writeValueAsString(myTickets);
		res.getWriter().print(json);
		res.setStatus(200);

	}
	
}

public void allReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
List<Reimbursement> allTickets = new ArrayList<>();
	
	//if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
		//this process below is to get our JSON String
		
		//BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
		
		//StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
		
		//String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
		
		//while(line != null) { //while there is data to read from the response data (res -> reader -> line)
			
			//sb.append(line); //add the contents of "line" to the StringBuilder
			//line = reader.readLine(); //assign line to the next line of data in the reader
			
			//so for every line of data that received from the response, 
			//we want to append it to the StringBuilder 
			//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!!
		//}
		
		//String body = new String(sb); //so we make a new String to hold the StringBuilder content
		
		//author = om.readValue(body, User.class);
		
		allTickets = reimbDao.getAllReimbursements();
		
		String json = om.writeValueAsString(allTickets);
		res.getWriter().print(json);
		res.setStatus(200);

	}
	
//}

public void pendingReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
List<Reimbursement> myTickets = new ArrayList<>();
	
	//if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
//		//this process below is to get our JSON String
//		
//		BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
//		
//		StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
//		
//		String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
//		
//		while(line != null) { //while there is data to read from the response data (res -> reader -> line)
//			
//			sb.append(line); //add the contents of "line" to the StringBuilder
//			line = reader.readLine(); //assign line to the next line of data in the reader
//			
//			//so for every line of data that received from the response, 
//			//we want to append it to the StringBuilder 
//			//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!!
//		//}
//		
//		String body = new String(sb); //so we make a new String to hold the StringBuilder content
//		
//		ReimbursementDTO reimbType = om.readValue(body, ReimbursementDTO.class);
		
		myTickets = reimbDao.getReimbursementByStatus(1);
		
		String json = om.writeValueAsString(myTickets);
		res.getWriter().print(json);
		res.setStatus(200);

	}
	
//}

public void approvedReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
List<Reimbursement> myTickets = new ArrayList<>();
	
	//if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
		//this process below is to get our JSON String
		
	//	BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
		
		//StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
		
//		String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
//		
//		while(line != null) { //while there is data to read from the response data (res -> reader -> line)
//			
//			sb.append(line); //add the contents of "line" to the StringBuilder
//			line = reader.readLine(); //assign line to the next line of data in the reader
			
			//so for every line of data that received from the response, 
			//we want to append it to the StringBuilder 
			//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!!
		//}
		
		//String body = new String(sb); //so we make a new String to hold the StringBuilder content
		
		//ReimbursementDTO reimbType = om.readValue(body, ReimbursementDTO.class);
		
		myTickets = reimbDao.getReimbursementByStatus(3);
		
		String json = om.writeValueAsString(myTickets);
		res.getWriter().print(json);
		res.setStatus(200);

	}
	
//}

public void deniedReimb(HttpServletRequest req, HttpServletResponse res) throws IOException {
	
List<Reimbursement> myTickets = new ArrayList<>();
	
	//if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
		//this process below is to get our JSON String
//		
//		BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
//		
	//StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
//		
//		String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
//		
//		while(line != null) { //while there is data to read from the response data (res -> reader -> line)
//			
//			sb.append(line); //add the contents of "line" to the StringBuilder
//			line = reader.readLine(); //assign line to the next line of data in the reader
			
			//so for every line of data that received from the response, 
			//we want to append it to the StringBuilder 
			//So we get all this previously JSON into one StringBuilder object. Parsing JSON into Java!!
		//}
		
	//	String body = new String(sb); //so we make a new String to hold the StringBuilder content
		
		//ReimbursementDTO reimbType = om.readValue(body, ReimbursementDTO.class);
		
		myTickets = reimbDao.getReimbursementByStatus(2);
		
		String json = om.writeValueAsString(myTickets);
		res.getWriter().print(json);
		res.setStatus(200);

	}
	
//}

public void approveItem(HttpServletRequest req, HttpServletResponse res) throws IOException {
	

	
	if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
		//this process below is to get our JSON String
		
		BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
		
		StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
		
		String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
		
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
		ReimbursementDTO lDTO = om.readValue(body, ReimbursementDTO.class); //we created a ReimbursementDTO using the JSON-turned-Java
		
		
		Reimbursement changeThis = reimbDao.getReimbursementByID(lDTO.reimb_id);
		
		reimbDao.setReimbursementStatus(changeThis, 3);
		
		
		res.setStatus(200);
		
	
		
	}
	
	
}

public void denyItem(HttpServletRequest req, HttpServletResponse res) throws IOException {
	

	
	if(req.getMethod().equals("POST")) { //making sure we actually got a POST request before executing. 
		
		//this process below is to get our JSON String
		
		BufferedReader reader = req.getReader(); //BufferedReader reads text from an input string (in our case JSON)
		
		StringBuilder sb = new StringBuilder(); //create an empty StringBuilder
		
		String line = reader.readLine(); //this will read the contents of the BufferedReader into a String
		
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
		ReimbursementDTO lDTO = om.readValue(body, ReimbursementDTO.class); //we created a ReimbursementDTO using the JSON-turned-Java
		
		
		Reimbursement changeThis = reimbDao.getReimbursementByID(lDTO.reimb_id);
		
		reimbDao.setReimbursementStatus(changeThis, 2);
		
		
		res.setStatus(200);
		
	
		
	}
	
	
}

}
