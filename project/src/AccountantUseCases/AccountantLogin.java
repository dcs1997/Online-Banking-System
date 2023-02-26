package AccountantUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;
import Exception.AccountantExp;
import Main.Main;

public class AccountantLogin {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter username");
		String username=sc.next();
		
		System.out.println("Enter password");
		String password=sc.next();
		
		AccountantDao dao = new AccountantDaoImpl();
		
		
		
		try {
			
			String result = dao.Login(username, password);
			System.out.println(result);
			Main.AccountantFunctionality();
			
		} catch (AccountantExp e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			Main.Bank_sys();
		}
		
		
		
		sc.close();
		
		
		
		
	}

}
