package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import admin.Admin;
import employee.Employee;
import employee.FixedPaidEmployee;
import employee.HourlyPaidEmployee;
import employee.SalesCommissionPaidEmployee;
import employee.SalesCommissionPlusBaseEmployee;

public class User {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean exit = false, adminLoggedIn = false;

		// Username:admin, Password:Admin123
		Admin adminLogin = Admin.getInstance();
		HashMap<Long, Employee> employees = new HashMap<>();
		Employee emp = null;
		String firstname, lastname, securityPassword;
		long empId;
		System.out.println("Welcome to Payroll application!");

		while (!exit) {
			try {
				System.out.println("press 1: To add employee");
				System.out.println("press 2: To get payroll");
				System.out.println("press 3: To set new admin password");
				System.out.println("press 4: To change employee security password");
				System.out.println("press 5: To increment base salary ");
				System.out.println("press 6: To increment fixed salary ");
				System.out.println("press 7: To increment rate of commission ");
				System.out.println("press 8: To increment hourly salary ");
				System.out.println("press 9: To exit");

				int x = Integer.parseInt(br.readLine());
				switch (x) {

				case 1:
					if (!adminLoggedIn) {
						System.out.println("Please enter admin username: ");
						String user = br.readLine().trim();
						System.out.println("Please enter admin password: ");
						String pass = br.readLine().trim();
						if (user.equals(adminLogin.getUsername()) && pass.equals(adminLogin.getPassword())) {
							adminLoggedIn = true;
							System.out.println("Logged in successfully");
						} else {
							System.out.println("Entered incorrect username or password");
							break;
						}
					}
					System.out.println("press 1: add employee with fixed salary");
					System.out.println("press 2: add employee paid hourly");
					System.out.println("press 3: add employess paid commission based only");
					System.out.println("press 4: add employess paid base amount + commission based");
					int y = Integer.parseInt(br.readLine());
					if (y < 1 || y > 4) {
						System.out.println("Invalid Choice");
						break;
					}
					empId = Employee.prevEmpId;
					System.out.println("Enter firstname:");
					firstname = br.readLine().trim();
					while (!firstname.equals("exit") && !Validator.nameValidator(firstname)) {
						System.out.println(
								"Name should contain only aplhabets and minimum length 3. Please re-enter. To exit - press exit");
						firstname = br.readLine().trim();
					}
					if (firstname.equals("exit"))
						break;

					System.out.println("enter lastname:");
					lastname = br.readLine().trim();
					while (!lastname.equals("exit") && !Validator.nameValidator(lastname)) {
						System.out.println(
								"Name should contain only aplhabets and minimum length 3. Please re-enter. To exit - press exit");
						lastname = br.readLine().trim();
					}
					if (lastname.equals("exit"))
						break;
					System.out.println("Enter security password:");
					securityPassword = br.readLine().trim();
					while (!securityPassword.equals("exit") && !Validator.passwordValidator(securityPassword)) {
						System.out.println(
								"Use 6 or more characters with mix of lower case letter, upper case letter and number. Please re-enter. To exit - press exit");
						securityPassword = br.readLine().trim();
					}
					if (securityPassword.equals("exit"))
						break;
					switch (y) {
					case 1:
						System.out.println("Enter fixed salary: ");
						double salary = Double.parseDouble(br.readLine());
						while (!Validator.amountValidator(salary)) {
							System.out.println("Salary cannot be negative. Please re-enter.");
							salary = Double.parseDouble(br.readLine());
						}
						emp = new FixedPaidEmployee(empId, firstname, lastname, securityPassword, salary);
						employees.put(empId, emp);
						break;

					case 2:
						System.out.println("Enter hourly salary: ");
						double perHourSalary = Double.parseDouble(br.readLine());
						while (!Validator.amountValidator(perHourSalary)) {
							System.out.println("Salary cannot be negative. Please re-enter.");
							perHourSalary = Double.parseDouble(br.readLine());
						}
						System.out.println("Enter hours: ");
						double hours = Double.parseDouble(br.readLine());
						while (!Validator.amountValidator(hours)) {
							System.out.println("Hours cannot be negative. Please re-enter.");
							hours = Double.parseDouble(br.readLine());
						}
						emp = new HourlyPaidEmployee(empId, firstname, lastname, securityPassword, perHourSalary,
								hours);
						employees.put(empId, emp);
						break;

					case 3:
						System.out.println("Enter sales made: ");
						double sales = Double.parseDouble(br.readLine());
						while (!Validator.amountValidator(sales)) {
							System.out.println("Sales cannot be negative. Please re-enter.");
							sales = Double.parseDouble(br.readLine());
						}
						System.out.println("Enter rate of commission: ");
						double rate = Double.parseDouble(br.readLine());
						while (!Validator.rateValidator(rate)) {
							System.out.println("Rate should be in range of 0-100. Please re-enter.");
							rate = Double.parseDouble(br.readLine());
						}
						emp = new SalesCommissionPaidEmployee(empId, firstname, lastname, securityPassword, sales,
								rate);
						employees.put(empId, emp);
						break;

					case 4:
						System.out.println("Enter base salary: ");
						double base = Double.parseDouble(br.readLine());
						while (!Validator.amountValidator(base)) {
							System.out.println("Salary cannot be negative. Please re-enter.");
							base = Double.parseDouble(br.readLine());
						}
						System.out.println("Enter sales made: ");
						sales = Double.parseDouble(br.readLine());
						while (!Validator.amountValidator(sales)) {
							System.out.println("Sales cannot be negative. Please re-enter.Please re-enter.");
							sales = Double.parseDouble(br.readLine());
						}
						System.out.println("Enter rate: ");
						rate = Double.parseDouble(br.readLine());
						while (!Validator.rateValidator(rate)) {
							System.out.println("Rate should be in range of 0-100. Please re-enter.");
							rate = Double.parseDouble(br.readLine());
						}
						emp = new SalesCommissionPlusBaseEmployee(empId, firstname, lastname, securityPassword, base,
								sales, rate);
						employees.put(empId, emp);
						break;

					}// INNER SWITCH CASE
					Employee.prevEmpId++;
					System.out.println("Employee with employee id " + empId + " created ");
					break;

				case 2:
					System.out.println("Enter employee id: ");
					long id = Long.parseLong(br.readLine());
					emp = employees.get(id);
					if (emp == null) {
						System.out.println("No such employee exist.");
						break;
					}
					System.out.println("Enter security password: ");
					String pass = br.readLine();
					if (!pass.equals(emp.getSecurtityPassword())) {
						System.out.println("Incorrect security password.");
						break;
					}
					System.out.println("Amount: " + emp.weeklyPay());
					break;

				case 3:
					System.out.println("Enter old password: ");
					String old = br.readLine().trim();
					System.out.println("Enter new password: ");
					String newpass = br.readLine().trim();
					while (!newpass.equals("exit") && !Validator.passwordValidator(newpass)) {
						System.out.println(
								"Use 6 or more characters with mix of lower case letter, upper case letter and number. Please re-enter. To exit - press exit");
						newpass = br.readLine().trim();
					}
					if (newpass.equals("exit"))
						break;
					System.out.println("Re-enter new password. ");
					String reNew = br.readLine().trim();
					if (!old.equals(adminLogin.getPassword())) {
						System.out.println("Enter wrong old password.");
					} else if (!newpass.equals(reNew)) {
						System.out.println("New password entered not matched.");
					} else {
						adminLogin.setPassword(newpass);
						System.out.println("Admin password changed successfully.");
					}
					break;

				case 4:
					System.out.println("Enter empId: ");
					id = Long.parseLong(br.readLine());
					if (!employees.containsKey(id)) {
						System.out.println("No such employee exist");
						break;
					}
					System.out.println("Enter old security password: ");
					old = br.readLine().trim();
					System.out.println("Enter new security password: ");
					newpass = br.readLine().trim();
					while (!newpass.equals("exit") && !Validator.passwordValidator(newpass)) {
						System.out.println(
								"Use 6 or more characters with mix of lower case letter, upper case letter and number. Please re-enter. To exit - press exit");
						newpass = br.readLine().trim();
					}
					if (newpass.equals("exit"))
						break;
					System.out.println("Re-enter new security password: ");
					reNew = br.readLine().trim();
					emp = employees.get(id);
					if (!old.equals(emp.getSecurtityPassword())) {
						System.out.println("Enter wrong old security password.");
					} else if (!newpass.equals(reNew)) {
						System.out.println("New security password entered not matched.");
					} else {
						emp.setSecurtityPassword(newpass);
						System.out.println("Security password changed successfully.");
					}
					break;

				case 5:
					if (!adminLoggedIn) {
						System.out.println("Please enter admin username: ");
						String user = br.readLine().trim();
						System.out.println("Please enter admin password: ");
						pass = br.readLine().trim();
						if (user.equals(adminLogin.getUsername()) && pass.equals(adminLogin.getPassword())) {
							adminLoggedIn = true;
							System.out.println("Logged in successfully.");
						} else {
							System.out.println("Entered incorrect username or password.");
							break;
						}
					}
					System.out.println("Enter the increment percent: ");
					double per = Double.parseDouble(br.readLine());
					while (!Validator.rateValidator(per) && per != 0) {
						System.out.println("Percent should be in range of 0-100. Please re-enter.To exit - press 0.");
						per = Double.parseDouble(br.readLine());
					}
					if (per == 0)
						break;
					for (Map.Entry<Long, Employee> e : employees.entrySet()) {
						if (e.getValue() instanceof SalesCommissionPlusBaseEmployee) {
							SalesCommissionPlusBaseEmployee tmp = (SalesCommissionPlusBaseEmployee) e.getValue();
							tmp.setBaseSalary(tmp.getBaseSalary() * (1 + per / 100));
							System.out.println("Base salary updated for empId:" + tmp.getEmpId());
						}
					}
					System.out.println("All updates made successfully.");
					break;

				case 6:
					if (!adminLoggedIn) {
						System.out.println("Please enter admin username: ");
						String user = br.readLine().trim();
						System.out.println("Please enter admin password: ");
						pass = br.readLine().trim();
						if (user.equals(adminLogin.getUsername()) && pass.equals(adminLogin.getPassword())) {
							adminLoggedIn = true;
							System.out.println("Logged in successfully.");
						} else {
							System.out.println("Entered incorrect username or password.");
							break;
						}
					}
					System.out.println("Enter the increment percent: ");
					per = Double.parseDouble(br.readLine());
					while (!Validator.rateValidator(per) && per != 0) {
						System.out.println("Percent should be in range of 0-100. Please re-enter. To exit - press 0.");
						per = Double.parseDouble(br.readLine());
					}
					if (per == 0)
						break;
					for (Map.Entry<Long, Employee> e : employees.entrySet()) {
						if (e.getValue() instanceof FixedPaidEmployee) {
							FixedPaidEmployee tmp = (FixedPaidEmployee) e.getValue();
							tmp.setSalary(tmp.getSalary() * (1 + per / 100));
							System.out.println("Fixed salary updated empId: " + tmp.getEmpId());
						}
					}
					System.out.println("All updates made successfully.");
					break;

				case 7:
					if (!adminLoggedIn) {
						System.out.println("Please enter admin username: ");
						String user = br.readLine().trim();
						System.out.println("Please enter admin password: ");
						pass = br.readLine().trim();
						if (user.equals(adminLogin.getUsername()) && pass.equals(adminLogin.getPassword())) {
							adminLoggedIn = true;
							System.out.println("Logged in successfully.");
						} else {
							System.out.println("Entered incorrect username or password.");
							break;
						}
					}
					System.out.println("Enter the increment percent: ");
					per = Double.parseDouble(br.readLine());
					while (!Validator.rateValidator(per) && per != 0) {
						System.out.println("Percent should be in range of 0-100. Please re-enter. To exit - press 0.");
						per = Double.parseDouble(br.readLine());
					}
					if (per == 0)
						break;
					for (Map.Entry<Long, Employee> e : employees.entrySet()) {
						if (e.getValue() instanceof SalesCommissionPaidEmployee) {
							SalesCommissionPaidEmployee tmp = (SalesCommissionPaidEmployee) e.getValue();
							tmp.setCommissionRate(tmp.getCommissionRate() * (1 + per / 100));
							System.out.println("Rate of commission updated for empId: " + tmp.getEmpId());
						}
					}
					System.out.println("All updates made successfully.");
					break;

				case 8:
					if (!adminLoggedIn) {
						System.out.println("Please enter admin username: ");
						String user = br.readLine().trim();
						System.out.println("Please enter admin password: ");
						pass = br.readLine().trim();
						if (user.equals(adminLogin.getUsername()) && pass.equals(adminLogin.getPassword())) {
							adminLoggedIn = true;
							System.out.println("Logged in successfully.");
						} else {
							System.out.println("Entered incorrect username or password.");
							break;
						}
					}
					System.out.println("Enter the increment percent: ");
					per = Double.parseDouble(br.readLine());
					while (!Validator.rateValidator(per) && per != 0) {
						System.out.println("percent should be in range of 0-100. Please re-enter. To exit - press 0.");
						per = Double.parseDouble(br.readLine());
					}
					if (per == 0)
						break;
					for (Map.Entry<Long, Employee> e : employees.entrySet()) {
						if (e.getValue() instanceof HourlyPaidEmployee) {
							HourlyPaidEmployee tmp = (HourlyPaidEmployee) e.getValue();
							tmp.setHourlyPay(tmp.getHourlyPay() * (1 + per / 100));
							System.out.println("Hourly updated for empId:" + tmp.getEmpId());
						}
					}
					System.out.println("All updates made successfully.");
					break;

				case 9:
					exit = true;
					break;

				default:
					System.out.println("Entered incorrect choice.");

				}// SWITCH CASE
			} // TRY
			catch (Exception e) {
				System.out.println("Incorrect Input Format.");
			}
		} // WHILE
		System.out.println("Application Exited.");
		br.close();
	}// MAIN
}// CLASS
