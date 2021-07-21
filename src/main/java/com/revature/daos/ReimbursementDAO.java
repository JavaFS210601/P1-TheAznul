package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.utils.ConnectionUtil;

public class ReimbursementDAO implements ReimbursementInterface{
	
	final Logger log = LogManager.getLogger(UserDAO.class);

	@Override
	public List<Reimbursement> getAllReimbursements() {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){//tries to establish a database connection
			ResultSet rs = null; //initialize an empty result set to store the results of our query
			
			String sql = "SELECT * FROM ers_reimbursement;"; //assigning the query to a string variable
			
			Statement s = conn.createStatement(); //creates an object to sent the query to our database
			
			rs = s.executeQuery(sql); // this will execute the query, using the statement object, and put it in our result set
			
			List<Reimbursement> reimbursementList = new ArrayList<>(); //creates a list to be populated with the returned items
			
			while(rs.next()) { //while there are results left in the result set
				//create a new item object from each returned record
				Reimbursement t = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						
						
						
						);
				
				//add the newly created item object into the array list
				reimbursementList.add(t);
				
			}
			return reimbursementList;
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, read did not succeed");
		}
		return null;
	}

	@Override
	public Reimbursement getReimbursementByID(int findID) {
		
		try(Connection conn = ConnectionUtil.getConnection()){//tries to establish a database connection
			ResultSet rs = null; //initialize an empty result set to store the results of our query
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_id = ?;"; //assigning the query to a string variable
			
			PreparedStatement ps = conn.prepareStatement(sql);//prepared statements are for SQL commands with parameters
			
			//use the prepared statement object to insert values into the SQL query
			//the values will come from the Item object we sent in
			ps.setInt(1, findID);
			
			
			rs = ps.executeQuery(); // this will execute the query, using the statement object, and put it in our result set
			
			List<Reimbursement> reimbursementList = new ArrayList<>(); //creates a list to be populated with the returned items
			
			while(rs.next()) { //while there are results left in the result set
				//create a new item object from each returned record
				Reimbursement t = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						
						
						
						);
				
				//add the newly created item object into the array list
				reimbursementList.add(t);
				
			}
			return reimbursementList.get(0);
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, read did not succeed");
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByStatus(int statusID) {
		
		try(Connection conn = ConnectionUtil.getConnection()){//tries to establish a database connection
			ResultSet rs = null; //initialize an empty result set to store the results of our query
			
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_status_id = ?;"; //assigning the query to a string variable
			
			PreparedStatement ps = conn.prepareStatement(sql);//prepared statements are for SQL commands with parameters
			
			//use the prepared statement object to insert values into the SQL query
			//the values will come from the Item object we sent in
			ps.setInt(1, statusID);
			
			
			rs = ps.executeQuery(); // this will execute the query, using the statement object, and put it in our result set
			
			List<Reimbursement> reimbursementList = new ArrayList<>(); //creates a list to be populated with the returned items
			
			while(rs.next()) { //while there are results left in the result set
				//create a new item object from each returned record
				Reimbursement t = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						
						
						
						);
				
				//add the newly created item object into the array list
				reimbursementList.add(t);
				
			}
			return reimbursementList;
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, read did not succeed");
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getReimbursementByUser(User inputUser) {
		
		try(Connection conn = ConnectionUtil.getConnection()){//tries to establish a database connection
			ResultSet rs = null; //initialize an empty result set to store the results of our query
			int authorID = inputUser.getUserID();
			String sql = "SELECT * FROM ers_reimbursement WHERE reimb_author = ?;"; //assigning the query to a string variable
			
			PreparedStatement ps = conn.prepareStatement(sql);//prepared statements are for SQL commands with parameters
			
			//use the prepared statement object to insert values into the SQL query
			//the values will come from the Item object we sent in
			ps.setInt(1, authorID);
			
			
			rs = ps.executeQuery(); // this will execute the query, using the statement object, and put it in our result set
			
			List<Reimbursement> reimbursementList = new ArrayList<>(); //creates a list to be populated with the returned items
			
			while(rs.next()) { //while there are results left in the result set
				//create a new item object from each returned record
				Reimbursement t = new Reimbursement(
						rs.getInt("reimb_id"),
						rs.getInt("reimb_amount"),
						rs.getTimestamp("reimb_submitted"),
						rs.getTimestamp("reimb_resolved"),
						rs.getString("reimb_description"),
						rs.getInt("reimb_author"),
						rs.getInt("reimb_resolver"),
						rs.getInt("reimb_status_id"),
						rs.getInt("reimb_type_id")
						
						
						
						);
				
				//add the newly created item object into the array list
				reimbursementList.add(t);
				
			}
			return reimbursementList;
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, read did not succeed");
		}
		
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReimbursementStatus(Reimbursement reimb, int newStatus) {
		
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE ers_reimbursement SET reimb_status_id = ?, reimb_author = ?, reimb_resolved = ?  WHERE reimb_id = ?;";
	
			Timestamp saveNow = new Timestamp(System.currentTimeMillis());
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, newStatus);
			ps.setInt(2, reimb.getReimb_author());
			ps.setTimestamp(3, saveNow);
			ps.setInt(4, reimb.getReimb_id());
			
			ps.executeUpdate();
			
			
			
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, update did not succeed");
		}
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public Reimbursement newReimbursement(Reimbursement t) {
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status_id, reimb_type_id)"
					+"VALUES (?, ?, ?, ?, ?, ?);";
			
			Timestamp saveNow = new Timestamp(System.currentTimeMillis());
			
			PreparedStatement ps = conn.prepareStatement(sql);//prepared statements are for SQL commands with parameters
			
			//use the prepared statement object to insert values into the SQL query
			//the values will come from the Item object we sent in
			ps.setInt(1, t.getReimb_amount());
			ps.setTimestamp(2, saveNow);
			ps.setString(3, t.getReimb_description());
			ps.setInt(4, t.getReimb_author());
			ps.setInt(5, t.getReimb_status_id());
			ps.setInt(6, t.getReimb_type_id());
			
			ps.executeUpdate(); //we use executeUpdate for insertions, updates, and deletes
			
			//send confirmation to the console if successful
			System.out.println("New Item "+ t.getReimb_description() + " added successfully");
			
			log.info("User has added a new item. The item name is " + t.getReimb_description());
		}
		catch(SQLException e) { //catches issues with accessing our data
			System.out.println("There was an issue accessing the database");
			e.printStackTrace();
			log.warn("Database connection failed, add item did not succeed");
		}
		// TODO Auto-generated method stub
		return null;
	}

}
