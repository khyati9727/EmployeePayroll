package employee;

//parent class for all types of employees
public abstract class Employee {

	public static long prevEmpId = 10001;
	private long empId;
	private String firstName;
	private String lastName;
	private String securtityPassword;

	Employee(long empId, String firstName, String lastName, String securtityPassword) {
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.securtityPassword = securtityPassword;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecurtityPassword() {
		return securtityPassword;
	}

	public void setSecurtityPassword(String securtityCode) {
		this.securtityPassword = securtityCode;
	}

	// abstract method
	public abstract double weeklyPay();
}
