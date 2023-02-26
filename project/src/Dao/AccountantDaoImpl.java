package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Exception.AccountantExp;
import Exception.CustomerExp;
import Model.Customer;
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

	@Override
	public String addCustomer(String name, String email, String password,long aadhar, long phone, String address, int balance)
			throws CustomerExp {
		// TODO Auto-generated method stub
		
		String res="Customer Not added";
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("insert into customer(name,email,password,aadhar,phone,address,balance) values(?,?,?,?,?,?,?)");     
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			ps.setLong(4, aadhar);
			ps.setLong(5, phone);
			ps.setString(6, address);
			ps.setInt(7, balance);
			
			int rs=ps.executeUpdate();
			
			if(rs>0) res="Customer "+name+" is Successfully added!";
			else throw new CustomerExp(res);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
			
		}
		
		return res;
	}

	@Override
	public String updateName(String name, long accountNo) throws CustomerExp {
		// TODO Auto-generated method stub
		String res="Customer's name is not updated";
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Update customer set name=? where accountNo=?");
			ps.setString(1, name);
			ps.setLong(2, accountNo);
			
			int x=ps.executeUpdate();
			
			if(x >0) res="Customer name has changed to "+name;
			else throw new CustomerExp(res);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return res;
	}

	@Override
	public String updateEmail(String email, long accountNo) throws CustomerExp {
		// TODO Auto-generated method stub
		
String res="Customer's email is not updated";
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Update customer set email=? where accountNo=?");
			ps.setString(1, email);
			ps.setLong(2, accountNo);
			
			int x=ps.executeUpdate();
			
			if(x >0) res="Customer email has changed to "+email;
			else throw new CustomerExp(res);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return res;
		
		
	}

	@Override
	public String updatePhone(long phoneNo, long accountNo) throws CustomerExp {
		// TODO Auto-generated method stub
String res="Customer's phone Number is not updated";
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Update customer set phone=? where accountNo=?");
			ps.setLong(1, phoneNo);
			ps.setLong(2, accountNo);
			
			int x=ps.executeUpdate();
			
			if(x >0) res="Customer phone Number has changed to "+phoneNo;
			else throw new CustomerExp(res);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return res;	
	}

	@Override
	public String updateAddress(long accountNo, String address) throws CustomerExp {
		// TODO Auto-generated method stub
String res="Customer's address is not updated";
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Update customer set address=? where accountNo=?");
			ps.setString(1, address);
			ps.setLong(2, accountNo);
			
			int x=ps.executeUpdate();
			
			if(x >0) res="Customer address has changed to "+address;
			else throw new CustomerExp(res);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return res;
		
		
		
		
	}

	@Override
	public String updateAadhar(long accountNo, long aadhar) throws CustomerExp {
		// TODO Auto-generated method stub
		
String res="Customer's aadhar Number is not updated";
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Update customer set aadhar=? where accountNo=?");
			ps.setLong(1, aadhar);
			ps.setLong(2, accountNo);
			
			int x=ps.executeUpdate();
			
			if(x >0) res="Customer aadhar Number has changed to "+aadhar;
			else throw new CustomerExp(res);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return res;	
		
		
		
	}

	@Override
	public String updatePassword(String password, long accountNo) throws CustomerExp {
		// TODO Auto-generated method stub
		

String res="Customer's password is not updated";
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Update customer set password=? where accountNo=?");
			ps.setString(1, password);
			ps.setLong(2, accountNo);
			
			int x=ps.executeUpdate();
			
			if(x >0) res="Customer password has changed to "+password;
			else throw new CustomerExp(res);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return res;
	}

	@Override
	public String deleteCustomer(long accountNo,String password) throws CustomerExp {
		// TODO Auto-generated method stub
		String res="Account is not deleted";
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Delete from customer where accountNo=? AND password=?");
			
			ps.setLong(1, accountNo);
			ps.setString(2, password);
			
			int x=ps.executeUpdate();
			
			if(x >0) res="Customer with account number "+accountNo+" is deleted successfully";
			else throw new CustomerExp(res);

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		return res;
	}

	@Override
	public Customer viewCustomer(long accountNo) throws CustomerExp {
		// TODO Auto-generated method stub
		Customer cus =new Customer();
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Select * from customer where accountNo=?");
			
			ps.setLong(1, accountNo);
			
			ResultSet rs =ps.executeQuery();
			
			if(rs.next()) {
				long acc = rs.getLong("accountNo");
				
				String n = rs.getString("name");
				
				String e = rs.getString("email");
				
				String p = rs.getString("password");
				
				long adhar = rs.getLong("aadhar");
				
                long m = rs.getLong("phone");
				
				
				
				String ad = rs.getString("address");
				
				int b = rs.getInt("balance");
				
				
				
				
				
				
				
				cus = new Customer(acc, n, e, p,adhar,m, ad, b);
			}
			else throw new CustomerExp("Invalid Account number: ");

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		
		return cus;
	}

	@Override
	public List<Customer> viewAllCustomer() throws CustomerExp {
		// TODO Auto-generated method stub
		
		List<Customer> li = new ArrayList<>();
		
		
		try(Connection conn=DBUtil.ProvideConnection()) {
			PreparedStatement ps= conn.prepareStatement("Select * from customer");
			
			
			ResultSet rs =ps.executeQuery();
			
			while(rs.next()) {
	
					
				
				long acc = rs.getLong("accountNo");
				
				String n = rs.getString("name");
				
				String e = rs.getString("email");
				
				String p = rs.getString("password");
				
				long adhar = rs.getLong("aadhar");
				
                long m = rs.getLong("phone");
				
				
				
				String ad = rs.getString("address");
				
				int b = rs.getInt("balance");
				
				
				
				
				
				
				
				Customer cus = new Customer(acc, n, e, p,adhar,m, ad, b);
				li.add(cus);
			}
		

			
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
		
		
		
		
		
		return li;
	}

	

	

}
