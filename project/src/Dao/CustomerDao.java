package Dao;

import java.util.List;

import Exception.CustomerExp;
import Model.Bank_Transaction;

public interface CustomerDao {
	
	public String CustomerLogin(String email, String password)throws CustomerExp; 
	
	public int viewBalance(long accountNo) throws CustomerExp;
	
	public int Deposit(long accountNo, int amount) throws CustomerExp; 
	
	public int withdraw(long accountNo, int amount) throws CustomerExp;
	
	public String transfer(long acc1, int amount, long acc2) throws CustomerExp;
	
	public List<Bank_Transaction> viewTransactionOfCustomer(long accountNo) throws CustomerExp;

}
