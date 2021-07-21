package com.revature.models;

public class User {
	
	private int userID;
	private String userName;
	private String userPassword;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private int userRoleID;
	
	
	//basic constructor
	public User() {
		super();
		
	}
	
	public User(int user_ID, String user_username, String user_password, String user_firstName, int user_roleID) {
		super();
		this.userID = user_ID;
		this.userName = user_username;
		this.userPassword = user_password;
		this.userFirstName = user_firstName;
		this.userRoleID = user_roleID;
		
		
	}
	
	
	
	//Auto generated getters and setters. Right click and choose source

	public User(int userID, String userName, String userPassword, String userFirstName, String userLastName,
			String userEmail, int userRoleID) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleID = userRoleID;
	}

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + userRoleID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userRoleID != other.userRoleID)
			return false;
		return true;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserRoleID() {
		return userRoleID;
	}

	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}
	
	
	

}
