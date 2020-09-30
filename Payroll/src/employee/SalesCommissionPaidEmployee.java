package employee;

//employees paid percentage of sales made 
public class SalesCommissionPaidEmployee extends Employee {

	private double salesCompleted;
	private double commissionRate;

	public SalesCommissionPaidEmployee(long empId, String firstName, String lastName, String securtityPassword,
			double salesCompleted, double commissionRate) {
		super(empId, firstName, lastName, securtityPassword);
		this.salesCompleted = salesCompleted;
		this.commissionRate = commissionRate;
	}

	public double getSalesCompleted() {
		return salesCompleted;
	}

	public void setSalesCompleted(double salesCompleted) {
		this.salesCompleted = salesCompleted;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	@Override
	public double weeklyPay() {
		return this.salesCompleted * this.commissionRate / 100;
	}

}
