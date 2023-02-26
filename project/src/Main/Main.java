package Main;

import java.util.Scanner;

import AccountantUseCases.AccountantLogin;
import AccountantUseCases.CustomerAdded;
import AccountantUseCases.CustomerDeleted;
import AccountantUseCases.UpdateAadharNumber;
import AccountantUseCases.UpdateAddress;
import AccountantUseCases.UpdateEmail;
import AccountantUseCases.UpdateName;
import AccountantUseCases.UpdatePassword;
import AccountantUseCases.UpdatePhoneNumber;
import AccountantUseCases.ViewAllCustomers;
import AccountantUseCases.ViewCustomer;
import ConsoleColors.ConsoleColors;
import CustomerUseCases.CustomerLogin;
import CustomerUseCases.CustomerViewAllTransactions;
import CustomerUseCases.CustomerViewBalance;
import CustomerUseCases.MoneyDeposit;
import CustomerUseCases.MoneyTransfer;
import CustomerUseCases.MoneyWithdraw;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Bank_sys();
		
		

	}
	
	
static Scanner sc = new Scanner(System.in);
	
	public static void Bank_sys() {
		
		
		System.out.println(ConsoleColors.GREEN_BOLD
				+"+============================================+"+"\n"
				+"|  DC BANK (Khayal Rakhe Parivar Jaisa)      |"+"\n"
				+"+============================================+"+"\n"
				+"|                                            |"+"\n"
				+"|  1. Login as Accountant                    |"+"\n"
				+"|  2. Login as Customer                      |"+"\n"
				+"|  3. Exit                                   |"+"\n"
				+"|                                            |"+"\n"
				+"+============================================+"+"\n"
				+ConsoleColors.RESET);
		
		
		
		String out = sc.next();
		int n=Integer.parseInt(out);
		
while(true) {
			
			if(n==1) {
			AccountantLogin.main(null);	
			
				
			
			}
			
			else if(n==2) {
				
				CustomerLogin.main(null);
				
				CustomerFunctionality();
				
				Bank_sys();
			}
			
			else { sc.close(); break;}
		}
		
	}
	
	
	
	
	public static void AccountantFunctionality() {
		
		
		System.out.println(ConsoleColors.GREEN_BOLD
				+ "+==============================================================+" + "\n"
				+ "|         Welcome to Accountant Portal                         |" + "\n"
				+ "+==============================================================+" + "\n"
				+ "|                                                              |" + "\n"
				+ "|  1. Add New Customer Account                                 |" + "\n"
				+ "|  2. Update Name of an existing accountholder                 |" + "\n"
				+ "|  3. Update Email of an existing accountholder                |" + "\n"
				+ "|  4. Update Contact Number of an existing accountholder       |" + "\n"
				+ "|  5. Update Address of an existing accountholder              |" + "\n"
				+ "|  6. Update password of an existing accountholder             |" + "\n"
				+ "|  7. Update Aadhar card of an existing accountholder          |" + "\n"
				+ "|  8. Remove the account by account number                     |" + "\n"
				+ "|  9. View particular account details by giving account number |" + "\n"
				+ "|  10. View the details of all accountholders                  |" + "\n"
				+ "|  11. View deposit and withdrawal operations for Customer     |" + "\n"
				+ "|  12. Back to Main Menu                                       |" + "\n"
				+ "|                                                              |" + "\n"
				+ "+==============================================================+" + "\n"
				+ConsoleColors.RESET);
		
		
		String out = sc.next();
		int n=Integer.parseInt(out);
		
		
		
		
		if(n==1) {
			
			CustomerAdded.main(null);
			
		}
		
		else if(n==2) {
			UpdateName.main(null);
			
		}
		
		
		else if(n==3) {
			UpdateEmail.main(null);
			
		}
		
		else if(n==4) {
			UpdatePhoneNumber.main(null);
			
		}
		
		else if(n==5) {
			UpdateAddress.main(null);
			
		}
		
		else if(n==6) {
			UpdatePassword.main(null);
			
		}
		
		else if(n==7) {
			UpdateAadharNumber.main(null);
			
		}
		
		
		else if(n==8) {
			CustomerDeleted.main(null);
			
		}
		
		else if(n==9) {
			ViewCustomer.main(null);
			
		}
		
		else if(n==10) {
			ViewAllCustomers.main(null);
			
			
		}
		
		else if(n==11) {
			UpdatePassword.main(null);
					}
		
		else if(n==12) {
			Bank_sys();
		}
		
		else {
			System.out.println("Please enter valid number");
			AccountantFunctionality();
		}
		
		
	}
	
	
	public static void CustomerFunctionality() {
		
		
		System.out.println(ConsoleColors.GREEN_BOLD+
	 			  "+================================+" +"\n"
	 			 +"|   Welcome To Customer Portal   |" +"\n"
				+ "+================================+" +"\n"
	 			+ "|                                |" +"\n"
				+ "|   1. View Balance              |" +"\n"
				+ "|   2. Deposit Money             |" +"\n"
				+ "|   3. Withdraw Money            |" +"\n"
				+ "|   4. Transfer Money            |" +"\n"
				+ "|   5. View Transaction History  |" +"\n"
				+ "|   6. LOGOUT                    |" +"\n"
				+ "|   7. Exit the application      |" +"\n"
				+ "|                                |" +"\n"
				+ "+================================+" +"\n"
				+ConsoleColors.RESET);
		
		
		String out = sc.next();
		sc.nextLine();
		int n=Integer.parseInt(out);
		
 if(n==1) {
			
			CustomerViewBalance.main(null);
			
		}
		
		else if(n==2) {
			MoneyDeposit.main(null);
			
		}
		
		
		else if(n==3) {
			MoneyWithdraw.main(null);
			
		}
		
		else if(n==4) {
			MoneyTransfer.main(null);
			
		}
		
		else if(n==5) {
			CustomerViewAllTransactions.main(null);
			
		}
		
		else if(n==6) {
			Bank_sys();
			
		}
		
		else if(n==7) {
			System.out.println("Thank you for Using DC Bank");
			sc.close(); 
			
			
		}
		
	}
	

}
