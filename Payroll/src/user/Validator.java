package user;

public class Validator {

	// should contain small letter + capital letter + number and minimum characters 6
	public static boolean passwordValidator(String password) {
		String regex = "[a-zA-Z0-9]{6,16}";
		if (password.matches(regex) && password.matches(".*[0-9].*") && password.matches(".*[a-z].*")
				&& password.matches(".*[A-Z].*")) {
			return true;
		}
		return false;
	}

	// should contain small letter or capital letter and minimum characters 3
	public static boolean nameValidator(String name) {
		String regex = "[a-zA-Z]{3,20}";
		if (name.matches(regex)) {
			return true;
		}
		return false;
	}

	// should be non negative number
	public static boolean amountValidator(double amount) {
		if (amount >= 0)
			return true;
		return false;
	}

	// should be number in range 0-100
	public static boolean rateValidator(double amount) {
		if (amount >= 0 && amount <= 100)
			return true;
		return false;
	}
}
