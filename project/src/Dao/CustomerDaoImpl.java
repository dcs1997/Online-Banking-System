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

	@Override
	public String CustomerLogin(String email, String password) throws CustomerExp {
		// TODO Auto-generated method stub
		
		String res="Incorrect Credentials please give the right username and password";

		try (Connection conn=DBUtil.ProvideConnection()){
			
			PreparedStatement ps= conn.prepareStatement("select name from customer where  email=? AND password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
                 if(rs.next()) {res="welcome "+rs.getString("name")+" as Customer";
                
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

	@Override
	public int Deposit(long accountNo, int amount) throws CustomerExp {
		// TODO Auto-generated method stub
		
int result = -1;
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("update Customer set balance = balance+? where accountNo = ?");
			ps.setInt(1, amount);
			ps.setLong(2, accountNo);
			int res = ps.executeUpdate();
			
			if(res > 0) {
				PreparedStatement ps2 = conn.prepareStatement("insert into Bank_Transaction(accountNo, deposit, timeOfTrans) values(?, ?, NOW())");
				ps2.setLong(1, accountNo);
				ps2.setInt(2, amount);
				
				int res2 = ps2.executeUpdate();
				if(res2 > 0) {
					PreparedStatement ps3 = conn.prepareStatement("select balance from customer where accountNo= ?");
					ps3.setLong(1, accountNo);
					
					
					ResultSet rs = ps3.executeQuery();
					if(rs.next()) {
						result = rs.getInt("balance");
					} else {
						throw new CustomerExp("Transaction could not be completed.");
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		
		return result;
		
	}

	@Override
	public int withdraw(long accountNo, int amount) throws CustomerExp {
		// TODO Auto-generated method stub
int result = -1;
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			if(amount<0) throw  new CustomerExp("Amount cannot be negative");
			
			int previousBal = viewBalance(accountNo);
			
			if(amount <= previousBal) {
				PreparedStatement ps = conn.prepareStatement("update Customer set balance = balance-? where accountNo=?");
				ps.setInt(1, amount);
				ps.setLong(2, accountNo);
				int res = ps.executeUpdate();
				
				if(res > 0) {
					PreparedStatement ps2 = conn.prepareStatement("insert into Bank_Transaction(accountNo, withdraw, timeOfTrans) values(?, ?, NOW())");
					ps2.setLong(1, accountNo);
					ps2.setInt(2, amount);
					
					int res2 = ps2.executeUpdate();
					if(res2 > 0) {
						PreparedStatement ps3 = conn.prepareStatement("select balance from customer where accountNo= ?");
						ps3.setLong(1, accountNo);
						ResultSet rs = ps3.executeQuery();
						if(rs.next()) {
							result = rs.getInt("balance");
						} else {
							throw new CustomerExp("Error in Transaction completion");
						}
					}
				}
				
			} else {
				throw new CustomerExp("Insufficient Balance...");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
		}
		
		return result;
		
		
	}

	@Override
	public String transfer(long account1, int amount, long account2) throws CustomerExp {
		// TODO Auto-generated method stub
		String result = "Account number doesnot exist... ";
		
		int previousBalance = viewBalance(account1);
		
		if(previousBalance >= amount && checkAccountBalance(account2)) {
			
			int with = withdraw(account1, amount);
			
			int depo = Deposit(account2, amount);
			
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

@Override
public List<Bank_Transaction> viewTransactionOfCustomer(long accountNo) throws CustomerExp {
	// TODO Auto-generated method stub
	
	
	List<Bank_Transaction> list = new ArrayList<>();
	
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
	
	
	

}
