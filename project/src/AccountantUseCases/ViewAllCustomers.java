package AccountantUseCases;


import java.util.List;


import Dao.AccountantDao;
import Dao.AccountantDaoImpl;
import Model.Customer;

public class ViewAllCustomers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
		AccountantDao dao = new AccountantDaoImpl();
		
		try {
			
			List<Customer> li = dao.viewAllCustomer();
			
			li.forEach(data ->{
				System.out.println("Name: " + data.getName());
				
				System.out.println("Account Number: " + data.getAccountNo());
				
				System.out.println("Email: " + data.getEmail());
				
				System.out.println("Phone Number: " + data.getPhone());
				
				System.out.println("Aadhar Number: " + data.getAadharNo());
				
				System.out.println("Address: " + data.getAddress());
				
				System.out.println("Balance: " + data.getBalance());
				
				System.out.println();
				
				
			});
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}


	}

}
