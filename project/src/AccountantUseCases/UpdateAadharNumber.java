package AccountantUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;

public class UpdateAadharNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter aadhar number to be updated");
			long aadhar=sc.nextLong();
			
			System.out.println("Enter account number: ");
			long accountNo=sc.nextLong();
			
			AccountantDao dao = new AccountantDaoImpl();
			
			
			try {
				String result = dao.updateAadhar(accountNo, aadhar);
				System.out.println(result);
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				
			}
	sc.close();

	}

}
