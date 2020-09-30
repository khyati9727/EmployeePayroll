package admin;

//Singleton class 
public class Admin {

	private static Admin admin = null;
	private String username = "admin";
	private String password = "Admin123";

	private Admin() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static Admin getInstance() {
		if (admin == null)
			admin = new Admin();
		return admin;
	}
}
