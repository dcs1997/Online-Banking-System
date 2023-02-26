package CustomerUseCases;

import java.util.Scanner;

import Dao.CustomerDao;
import Dao.CustomerDaoImpl;
import Main.Main;

public class MoneyTransfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter account number from money should be dedudcted");
			long acc1 = sc.nextLong();
			
			System.out.println("Enter account number where money to be deposited");
			long acc2 = sc.nextLong();
			
			
			System.out.println("Enter amount");
			int money = sc.nextInt();
			
			CustomerDao dao = new CustomerDaoImpl();
			
			try {
				
				
				String res = dao.transfer(acc1, money, acc2);
				
				
				System.out.println(res);
	            Main.CustomerFunctionality();

				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
	            Main.CustomerFunctionality();

			}

			sc.close();

	}

}
