package employee;

//employees with fixed income
public class FixedPaidEmployee extends Employee {

	private double salary;

	public FixedPaidEmployee(long empId, String firstName, String lastName, String securtityPassword, double salary) {
		super(empId, firstName, lastName, securtityPassword);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public double weeklyPay() {
		return this.salary;
	}

}
