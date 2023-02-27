package Dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.CustomerExp;
import Model.Bank_Transaction;
import Utility.DBUtil;

public class CustomerDaoImpl implements CustomerDao{

	static long acc=0;
	@Override
	public String CustomerLogin(String email, String password) throws CustomerExp {
		// TODO Auto-generated method stub
		String res="Incorrect Credentials please give the right username and password";

		try (Connection conn=DBUtil.ProvideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select name, accountNo from customer where  email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
                 if(rs.next()) {res="welcome "+rs.getString("name")+" as Customer";
                 
                 acc=rs.getLong("accountNo");
                 System.out.println(acc);
                
                 }
			
			else throw new CustomerExp(res);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getStackTrace();
			
		}
		return res;
	}

	@Override
	public int viewBalance(long accountNo) throws CustomerExp {
		// TODO Auto-generated method stub
		
		if(accountNo==acc) {
		
		
		int response = -1;
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("select balance from Customer where accountNo = ?");
			ps.setLong(1, accountNo);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())  response = rs.getInt("balance");
				
			 else throw new CustomerExp("Invalid Account Number.");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		return response;
		}
		
		else {
			throw new CustomerExp("Account number does not match 5");
		    
		}
	}

	
	
	@Override
	public List<Bank_Transaction> viewTransactionOfCustomer(long accountNo) throws CustomerExp {
		// TODO Auto-generated method stub
		List<Bank_Transaction> list = new ArrayList<>();
		
		if(accountNo!=acc) {
			 throw new CustomerExp("Wrong account number");
		}
		try(Connection conn = DBUtil.ProvideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from  Bank_Transaction where accountNo = ?");
			ps.setLong(1, accountNo);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int transid = rs.getInt("transId");
				long acc = rs.getLong("accountNo");
				long depo = rs.getLong("deposit");
				long with = rs.getLong("withdraw");
				Timestamp t = rs.getTimestamp("timeOfTrans");
				
				Bank_Transaction ts = new Bank_Transaction(transid, acc, depo, with, t);
				list.add(ts);
			}
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		return list;
		
	}
		
	
	


	@Override
	public String transfer(long account1, int amount, long account2) throws CustomerExp {
		// TODO Auto-generated method stub
		String result = "Account number doesnot exist... ";
		
		AccountantDao acd =new AccountantDaoImpl();
		
		if(account1!=acc) {
			
			throw new CustomerExp("Please enter valid account");
		}
		
		
		int previousBalance = viewBalance(account1);
		
		if(previousBalance >= amount && checkAccountBalance(account2)) {
			
			int with = acd.withdraw(account1, amount);
			
			int depo = acd.Deposit(account2, amount);
			
			if(with != -1 && depo != -1)   result = "New balance in account "+account1 +" is "+ with +" \n"+" New balance in account " +account2+" is "+depo; 
			
			else   throw new CustomerExp(result);
			
		} 
		
		else {
			
			if(checkAccountBalance(account2) == false)  throw new CustomerExp(result);
			
			else throw new CustomerExp("Insufficient Balance.");
			
		}
		
		
		return result;
	}
	
private boolean checkAccountBalance(long account2) {
		
	try(Connection conn = DBUtil.ProvideConnection()) {
			PreparedStatement ps=conn.prepareStatement("select * from Customer where accountNo = ?");
			
			ps.setLong(1, account2);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
		
	}


	
	

}
