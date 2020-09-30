package employee;

//employees paid base salary and percentage of sales made 
public class SalesCommissionPlusBaseEmployee extends SalesCommissionPaidEmployee {

	private double baseSalary;

	public SalesCommissionPlusBaseEmployee(long empId, String firstName, String lastName, String securtityPassword,
			double baseSalary, double salesCompleted, double commissionRate) {
		super(empId, firstName, lastName, securtityPassword, salesCompleted, commissionRate);
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Override
	public double weeklyPay() {
		return this.baseSalary + super.weeklyPay();
	}

}
