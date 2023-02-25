package Model;

public class Customer {
	private long accountNo;
	private String name;
	private String email;
	private String password;
	private long aadharNo;
	private long phone;
	private String address;
	private int balance;
	public Customer() {
		super();
	}
	public Customer(long accountNo, String name, String email, String password, long aadharNo, long phone, String address,
			int balance) {
		super();
		this.accountNo = accountNo;
		this.name = name;
		this.email = email;
		this.password = password;
		this.aadharNo = aadharNo;
		this.phone = phone;
		this.address = address;
		this.balance = balance;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Customer [accountNo=" + accountNo + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", aadharNo=" + aadharNo + ", phone=" + phone + ", address=" + address + ", balance=" + balance + "]";
	}
	
	
	

}
