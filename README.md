# EmployeePayroll Application

This is a console application used for calulating and viewing payroll. 
1. user package
	1. User Class - This class has the main method.
	2. Validator class - This class is used for validating the input by user. 
2. admin package
	1. Admin class - Used to store admin details. singlton class allows single lazy instantiate of type admin. 
		        The admin account details:-
			username - "admin"
			password - "Admin123"

	Admin called methods:-  
		1. Admin can add other employees.
		2. Admin can change password.
		3. Admin can increment base salary.
		4. Admin can increment fixed salary.
		5. Admin can increment rate of commission.
		6. Admin can increment hourly salary.

3. employee package
	1. Employee class - This is super class of all types of employees.
	2. FixedPaidEmployee class - These are employees with fixed weekly income regardless of working hours and sales made.
	3. HourlyPaidEmployee class - These are employees paid based on hours worked and paid 1.5 times for overtime work( work hours - 40 hours).
	4. SalesCommissionPaidEmployee class - These are employees paid commission on the sales made by them. This is the parent class of SalesCommissionPlusBaseEmployee class.
	5. SalesCommissionPlusBaseEmployee class - These are employees paid base salary and commission on the sales made by them. 

	Employee called methods:-
		1. employee can change security password for payroll.
		2. employee can view his own payroll.
