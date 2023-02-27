package CustomerUseCases;

import java.util.Scanner;

import Dao.AccountantDao;
import Dao.AccountantDaoImpl;

import Main.Main;

public class MoneyWithdraw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter account number");
			long acc = sc.nextLong();
			
			System.out.println("Enter amount to be withdrawn");
			int money = sc.nextInt();
			
			AccountantDao dao = new AccountantDaoImpl();

			
			try {
				
				
				int res = dao.withdraw(acc, money);
				
//				if(res<0) System.out.println("Invalid amount to be withdrawn ");
				 System.out.println(res);
				 Main.AccountantFunctionality();

				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
				Main.AccountantFunctionality();

			}

			sc.close();

	}

}
