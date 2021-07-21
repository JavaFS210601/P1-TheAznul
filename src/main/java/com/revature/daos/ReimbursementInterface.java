package com.revature.daos;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface ReimbursementInterface {
	
	public List<Reimbursement> getAllReimbursements();
	
	public Reimbursement getReimbursementByID(int findID);
	
	public List<Reimbursement> getReimbursementByStatus(int statusID);
	
	public List<Reimbursement> getReimbursementByUser(User inputUser);
	
	public void setReimbursementStatus(Reimbursement reimb, int newStatus);
	
	public Reimbursement newReimbursement(Reimbursement addItem);
	
	
	

}
