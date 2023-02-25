package Dao;

import Exception.AccountantExp;
import Exception.CustomerExp;

public interface AccountantDao {
	
	public String Login(String username, String password) throws AccountantExp;
	
	public String addCustomer(String name, String email, String password,long aadhar, long phone, String address, int balance) throws CustomerExp;

	public String updateName(String name, long accountNo) throws CustomerExp;
	
	public String updateEmail(String email, long accountNo) throws CustomerExp;
	
	public String updatePhone(long phoneNo, long accountNo) throws CustomerExp;
	
	public String updateAddress(long accountNo,String address) throws CustomerExp;
	
	public String updateAadhar(long accountNo,long aadhar) throws CustomerExp;
	
	public String updatePassword(String password, long accountNo) throws CustomerExp;
}
