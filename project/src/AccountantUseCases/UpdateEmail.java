package AccountantUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;

public class UpdateEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
     Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter email to be updated");
		String email=sc.next();
		
		System.out.println("Enter account number: ");
		long accountNo=sc.nextLong();
		
		AccountantDao dao = new AccountantDaoImpl();
		
		
		try {
			String result = dao.updateEmail(email, accountNo);
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			
		}
sc.close();

	}

}
