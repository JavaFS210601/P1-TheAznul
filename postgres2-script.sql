CREATE TABLE ers_reimbursement_type (
reimb_type_id SERIAL PRIMARY KEY,
reimb_type varchar
);

CREATE TABLE ers_reimbursement_status (
reimb_status_id SERIAL PRIMARY KEY,
reimb_status varchar
);

CREATE TABLE ers_user_roles (
ers_user_role_id SERIAL PRIMARY KEY,
user_role varchar
);

CREATE TABLE ers_users (
ers_users_id SERIAL PRIMARY KEY,
ers_username varchar unique,
ers_password varchar,
user_first_name varchar,
user_last_name varchar,
user_email varchar UNIQUE,
user_role_id int REFERENCES ers_user_roles(ers_user_role_id)
);

CREATE TABLE ers_reimbursement (
reimb_id SERIAL PRIMARY key,
reimb_amount int,
reimb_submitted TIMESTAMP,
reimb_resolved TIMESTAMP,
reimb_description VARCHAR,
reimb_author int REFERENCES ers_users(ers_users_id),
reimb_resolver int REFERENCES ers_users(ers_users_id),
reimb_status_id int REFERENCES ers_reimbursement_status(reimb_status_id),
reimb_type_id int REFERENCES ers_reimbursement_type(reimb_type_id)
);

INSERT INTO ers_user_roles (user_role) VALUES ('Finance Manager');
INSERT INTO ers_user_roles (user_role) VALUES ('Employee');

INSERT INTO ers_reimbursement_status (reimb_status) VALUES ('Pending'), ('Denied'), ('Approved');

INSERT INTO ers_reimbursement_type (reimb_type) VALUES ('Lodging'), ('Travel'), ('Food'), ('Other');

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
VALUES ('ovar', 'pass', 'Ovar', 'Seer', 'invalidEmail', 1),
('totally', 'secure', 'Emplo', 'yee', 'lessValidEmail', 2);

INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
VALUES (404, 'Couldnt find any previous sample data', 2, 1, 4);

INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
VALUES (404, 'Deny this', 2, 2, 4);

INSERT INTO ers_reimbursement (reimb_amount, reimb_description, reimb_author, reimb_status_id, reimb_type_id) 
VALUES (200, 'approved sample', 2, 3, 4);