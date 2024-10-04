CREATE DATABASE employeeManagementSystem;

USE employeemanagementsystem;



CREATE TABLE login(
	username VARCHAR(20), password VARCHAR(20)
);
INSERT INTO login VALUES('ganesh', '12345');



CREATE TABLE employee_details(
	name VARCHAR(20), motherName VARCHAR(20), DOB VARCHAR(20), salary VARCHAR(24), Address VARCHAR(30),
    phone VARCHAR(15), email VARCHAR(30), designation VARCHAR(20), 
    education VARCHAR(10), fatherName VARCHAR(20), aadhaar VARCHAR(15), employeeID VARCHAR(10)
);



SELECT * FROM login;
SELECT * FROM employee_details;