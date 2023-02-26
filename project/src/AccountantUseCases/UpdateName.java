package AccountantUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;
import Main.Main;

public class UpdateName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter name to be updated");
		String name=sc.next();
		
		System.out.println("Enter account number: ");
		long accountNo=sc.nextLong();
		
		AccountantDao dao = new AccountantDaoImpl();
		
		
		try {
			String result = dao.updateName(name, accountNo);
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
