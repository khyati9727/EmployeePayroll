package employee;

//employees paid on the basis of working hours and paid 1.5 times for working extra hours (40 hours are standard)
public class HourlyPaidEmployee extends Employee {

	private double hourlyPay;
	private double hours;

	public HourlyPaidEmployee(long empId, String firstName, String lastName, String securtityPassword, double hourlyPay,
			double hours) {
		super(empId, firstName, lastName, securtityPassword);
		this.hourlyPay = hourlyPay;
		this.hours = hours;
	}

	public double getHourlyPay() {
		return hourlyPay;
	}

	public void setHourlyPay(double hourlyPay) {
		this.hourlyPay = hourlyPay;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	@Override
	public double weeklyPay() {
		double excess = 0, standard = getHours();
		if (hours > 40) {
			excess = standard - 40;
			standard -= excess;
		}
		return getHourlyPay() * (standard + excess * 1.5);
	}

}
