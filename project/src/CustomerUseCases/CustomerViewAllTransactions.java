package CustomerUseCases;


import java.util.List;
import java.util.Scanner;

import Dao.CustomerDao;
import Dao.CustomerDaoImpl;
import Main.Main;
import Model.Bank_Transaction;

public class CustomerViewAllTransactions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Scanner sc = new Scanner(System.in);
			
			
			System.out.println("Enter account number to see the transaction");
			long acc = sc.nextLong();
		
		CustomerDao dao = new CustomerDaoImpl();
		
		sc.close();
		
		
		
		try {
			
			List<Bank_Transaction> list = dao.viewTransactionOfCustomer(acc);
			
			list.forEach(data ->{
				
				System.out.println("Transaction data: " + data.getTimeOfTrans());
			});
			
            Main.CustomerFunctionality();

			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
            Main.CustomerFunctionality();

		}

	}

}
