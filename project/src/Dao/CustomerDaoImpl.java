package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.CustomerExp;
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

}
