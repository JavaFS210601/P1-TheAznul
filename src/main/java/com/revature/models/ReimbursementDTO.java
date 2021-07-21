package com.revature.models;

import java.sql.Timestamp;

public class ReimbursementDTO {
	
	public int reimb_id;
	public int reimb_amount;
	public Timestamp reimb_submitted;
	public Timestamp reimb_resolved;



	public String reimb_description;
	public int reimb_author;
	public int reimb_resolver;
	public int reimb_status_id;
	public int reimb_type_id;
	
	
	public ReimbursementDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementDTO(int reimb_id) {
		super();
		this.reimb_id = reimb_id;
	}

	public ReimbursementDTO(int reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, int reimb_author, int reimb_resolver, int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_resolver = reimb_resolver;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}


	public ReimbursementDTO(int reimb_amount, String reimb_description, int reimb_author, int reimb_status_id,
			int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}


	public ReimbursementDTO(int reimb_amount, Timestamp reimb_submitted, String reimb_description, int reimb_author,
			int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_description = reimb_description;
		this.reimb_author = reimb_author;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}


	public ReimbursementDTO(int reimb_amount, String reimb_description, int reimb_status_id, int reimb_type_id) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_description = reimb_description;
		this.reimb_status_id = reimb_status_id;
		this.reimb_type_id = reimb_type_id;
	}


	
	
	
	
	

}
