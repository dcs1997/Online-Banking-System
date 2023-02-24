package Dao;

import Exception.AccountantExp;

public interface AccountantDao {
	
	public String Login(String username, String password) throws AccountantExp;

}
