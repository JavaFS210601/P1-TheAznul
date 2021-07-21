package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.LoginController;
import com.revature.controllers.ReimbursementController;
import com.revature.daos.UserDAO;
import com.revature.models.User;
import com.revature.services.LoginService;

public class BaseServlet extends HttpServlet{
	
	private LoginController lc = new LoginController();
	private ReimbursementController rc = new ReimbursementController();


	
	//note the method signature of the following doGet/Post methods. They will ALWAYS be the same
	//you'll be expected to know this method signature ;)
	
	
	//overriding the doGet method
	//this is the method that will execute if our HelloServlet receives a GET request
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw = res.getWriter(); //this is how we write to our Response Object
		
		res.setContentType("application/json"); //set the content of our response object to be JSON
		
		//by default, Tomcat will send back a successful status code (200) if a request gets handled.
		//since we have a master servlet that takes all requests, this means all requests will get hendled.
		//this can lead to problems - we don't want a 200 if the request isn't handled correctly
		//thus, by default, we'll set the status code to 404, and change it in our code upon success.
		res.setStatus(404);
		
		
		//Now we want to write some code that will determine where requests get sent.
		
		String URI = req.getRequestURI().replace("/P1-TheAznul/", "");
		//getting the request URI, and stripping out the base URL
		//so we'll just be left with the endpoint (e.g. "avengers", "login") to use in a switch
		
		//pw.print("<h1>Hello from your doGet method</h1>"); //use the PrintWriter to write some HTML
		
		//res.setStatus(200); //successful status code - optional, but good to show it working in postman/in general
		
switch(URI) {
		
			
		case "login": 
			
			lc.login(req, res);
					
			break;
			
		case "alltickets":
			rc.allReimb(req, res);
			
			break;
			
		
	case "approved":
		rc.approvedReimb(req, res);
		
		break;
		
	case "denied":
		rc.deniedReimb(req, res);
		
		break;
		
	case "pending":
		rc.pendingReimb(req, res);
	break;
		
	case "byUser":
		rc.myReimb(req, res);
		
		break;
		
	case "addTicket":
		rc.addItem(req, res);
		
		break;
		
	case "approve":
		rc.approveItem(req, res);
		break;
		
	case "deny":
		rc.denyItem(req, res);
		break;
		
	}


		
	}
	
	//Now we have our first servlet!! 
	//We now have to map the servlet in the web.xml so that tomcat can acknowledge its existence 
	
	
	//overriding the doPost method
	//this is the method that will execute if our HelloServlet receives a POST request
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
		//this sends every POST request to the doGet method, why???
		//I only want one switch statement in this Servlet. It can get very messy otherwise
		//and we'll differentiate get from post in the controllers instead of the servlet.
		
	}
	

}
