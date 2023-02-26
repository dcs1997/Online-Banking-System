package AccountantUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;
import Main.Main;

public class CustomerAdded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner sc = new Scanner(System.in);
        

		
		System.out.println("Enter name");
		String name=sc.next();
		
		System.out.println("Enter email");
		String email=sc.next();

		System.out.println("Enter password");
		String password=sc.next();
		
		System.out.println("Enter aadhar");
		long aadhar=sc.nextLong();
		
		System.out.println("Enter phone Number");
		long phone=sc.nextLong();
		
		System.out.println("Enter address");
		String address=sc.next();
		
		System.out.println("Enter balance");
		int balance=sc.nextInt();

		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			String result = dao.addCustomer(name, email, password, aadhar, phone, address, balance);
			System.out.println(result);
			Main.AccountantFunctionality();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			Main.AccountantFunctionality();
		}
		
		sc.close();
		
		
	}

}
