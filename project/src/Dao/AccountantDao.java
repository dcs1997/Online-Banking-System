package Dao;

import java.util.List;

import Exception.AccountantExp;
import Exception.CustomerExp;
import Model.Customer;

public interface AccountantDao {
	//Accoontant login details
	
	public String Login(String username, String password) throws AccountantExp;
	
	//adding the customer
	
	public String addCustomer(String name, String email, String password,long aadhar, long phone, String address, int balance) throws CustomerExp;

	//update methods
	
	public String updateName(String name, long accountNo) throws CustomerExp;
	
	public String updateEmail(String email, long accountNo) throws CustomerExp;
	
	public String updatePhone(long phoneNo, long accountNo) throws CustomerExp;
	
	public String updateAddress(long accountNo,String address) throws CustomerExp;
	
	public String updateAadhar(long accountNo,long aadhar) throws CustomerExp;
	
	public String updatePassword(String password, long accountNo) throws CustomerExp;
	
	//delete method
	
	public String deleteCustomer(long accountNo,String password) throws CustomerExp;
	
	//viewing customer details 
	
	public  Customer viewCustomer(long accountNo) throws CustomerExp;
	
	public List<Customer> viewAllCustomer() throws CustomerExp;

	
	
}
