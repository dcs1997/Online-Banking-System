package CustomerUseCases;

import java.util.Scanner;

import Dao.CustomerDao;
import Dao.CustomerDaoImpl;
import Main.Main;

public class CustomerLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter email");
		String email = sc.next();
		
		System.out.println("Enter password");
		String password = sc.next();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		
		try {
			String res=dao.CustomerLogin(email, password);
			System.out.println(res);

            Main.CustomerFunctionality();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println(e.getMessage());
			Main.Bank_sys();
		}
		sc.close();
	}

}
