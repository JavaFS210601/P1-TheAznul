package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class UserDAO implements UserInterface {
	
	final Logger log = LogManager.getLogger(UserDAO.class);


	@Override
	public List<User> getAllUsers() {

			// TODO Auto-generated method stub
			try(Connection conn = ConnectionUtil.getConnection()){//tries to establish a database connection
				ResultSet rs = null; //initialize an empty result set to store the results of our query
				
				String sql = "SELECT * FROM ers_users;"; //assigning the query to a string variable
				
				Statement s = conn.createStatement(); //creates an object to sent the query to our database
				
				rs = s.executeQuery(sql); // this will execute the query, using the statement object, and put it in our result set
				
				List<User> userList = new ArrayList<>(); //creates a list to be populated with the returned items
				
				while(rs.next()) { //while there are results left in the result set
					//create a new item object from each returned record
					User t = new User(
							rs.getInt("ers_users_id"),
							rs.getString("ers_username"),
							rs.getString("ers_password"),
							rs.getString("user_first_name"),
							rs.getString("user_last_name"),
							rs.getString("user_email"),
							rs.getInt("user_role_id")
							
							
							);
					
					//add the newly created item object into the array list
					userList.add(t);
					
				}
				return userList;
				
			}
			catch(SQLException e) { //catches issues with accessing our data
				System.out.println("There was an issue accessing the database");
				e.printStackTrace();
				log.warn("Database connection failed, read did not succeed");
			}
			
			
			
			
			
			return null;
		}

		


	@Override
	public User getUserByID(int userID) {
		// TODO Auto-generated method stub
		
		try(Connection conn = ConnectionUtil.getConnection()){//tries to establish a database connection
			ResultSet rs = null; //initialize an empty result set to store the results of our query
			
			String sql = "SELECT * FROM ers_users WHERE ers_users_id = ?;"; //assigning the query to a string variable
PreparedStatement ps = conn.prepareStatement(sql);//prepared statements are for SQL commands with parameters
			
			//use the prepared statement object to insert values into the SQL query
			//the values will come from the Item object we sent in
			ps.setInt(1, userID);
			
			
			rs = ps.executeQuery(); // this will execute the query, using the statement object, and put it in our result set
			
			List<User> userList = new ArrayList<>(); //creates a list to be populated with the returned items
			
			while(rs.next()) { //while there are results left in the result set
				//create a new item object from each returned record
				User t = new User(
						rs.getInt("ers_users_id"),
						rs.getString("ers_username"),
						rs.getString("ers_password"),
						rs.getString("user_first_name"),
						rs.getString("user_last_name"),
						rs.getString("user_email"),
						rs.getInt("user_role_id")
						
						
						);
				
				//add the newly created item object into the array list
				userList.add(t);
				
			}
			return userList.get(0);
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, read did not succeed");
		}
		
		
		
		
		
		return null;
	}



}
	
	


