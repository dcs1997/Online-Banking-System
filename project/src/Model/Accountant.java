package Model;

public class Accountant {
	
	private int accountantId;
	private String email;
	private String password;
	private String username;
	private String name;
	public Accountant() {
		super();
	}
	public Accountant(int accountantId, String email, String password, String username, String name) {
		super();
		this.accountantId = accountantId;
		this.email = email;
		this.password = password;
		this.username = username;
		this.name = name;
	}
	public int getAccountantId() {
		return accountantId;
	}
	public void setAccountantId(int accountantId) {
		this.accountantId = accountantId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Accountant [accountantId=" + accountantId + ", email=" + email + ", password=" + password
				+ ", username=" + username + ", name=" + name + "]";
	}
	
	

}
