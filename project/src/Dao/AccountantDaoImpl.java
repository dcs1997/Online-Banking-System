package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Exception.AccountantExp;
import Utility.DBUtil;

public class AccountantDaoImpl implements AccountantDao{

	@Override
	public String Login(String username, String password) throws AccountantExp {
		// TODO Auto-generated method stub
		
		String res="Invalid Details please check your username and pasword";
		
		
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			
			PreparedStatement ps= conn.prepareStatement("select name from accountant where  username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) res="welcome "+rs.getString("name")+" as Accountant";
			
			else throw new AccountantExp(res);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.getStackTrace();
			
		}
		return res;
	}

}
