package CustomerUseCases;

import java.util.Scanner;

import Dao.CustomerDao;
import Dao.CustomerDaoImpl;
import Main.Main;

public class MoneyDeposit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
      Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account number");
		long acc = sc.nextLong();
		
		System.out.println("Enter amount to be inserted");
		int money = sc.nextInt();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		try {
			
			
			int res = dao.Deposit(acc, money);
			
			if(res<0) System.out.println("Invalid amount to be added ");
			else System.out.println(res);
			
            Main.CustomerFunctionality();

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
            Main.CustomerFunctionality();

		}

		sc.close();
	}

}
