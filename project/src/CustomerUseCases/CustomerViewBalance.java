package CustomerUseCases;

import java.util.Scanner;

import Dao.CustomerDao;
import Dao.CustomerDaoImpl;
import Exception.CustomerExp;

public class CustomerViewBalance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter account Number");
		long accountNo = sc.nextLong();
		
		sc.close();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		
		try {
			int res = dao.viewBalance(accountNo);
			if(res != -1) {
				System.out.println("Balance: " + res);
			} else {
				System.out.println("Invalid account number.");
			}
		} catch (CustomerExp e) {
			System.out.println(e.getMessage());
		}

	}

}
