package Dao;

import Exception.CustomerExp;

public interface CustomerDao {
	
	public String CustomerLogin(String email, String password)throws CustomerExp; 

}
