package AccountantUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;
import Main.Main;
import Model.Customer;

public class ViewCustomer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account number: ");
		long accountNo=sc.nextLong();
		
		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			
			Customer c= dao.viewCustomer(accountNo);
			
			System.out.println("Name: " + c.getName());
			
			System.out.println("Account Number: " + c.getAccountNo());
			
			System.out.println("Email: " + c.getEmail());
			
			System.out.println("Phone Number: " + c.getPhone());
			
			System.out.println("Aadhar Number: " + c.getAadharNo());
			
			System.out.println("Address: " + c.getAddress());
			
			System.out.println("Balance: " + c.getBalance());
			
			Main.AccountantFunctionality();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		sc.close();
	}

}
