package AccountantUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;
import Main.Main;

public class CustomerDeleted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Enter account number which needs to be deleted: ");
		long accountNo=sc.nextLong();
		
		System.out.println("Enter account's password");
		String password=sc.next();
		
		
		
		AccountantDao dao = new AccountantDaoImpl();
		
		
		try {
			String result = dao.deleteCustomer(accountNo,password);
			System.out.println(result);
			Main.AccountantFunctionality();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
sc.close();

	}

}
