package ui;

import java.util.*;
import java.util.Scanner;

import databases.CustomerDatabase;
import models.CustomerModel;
import services.CustomerService;

public class CustomerMenu {
	
	static CustomerModel editDetails(Scanner sc){
		
		CustomerModel customer = new CustomerModel();
		
		System.out.print("Enter name");
		customer.setName(sc.next());
		
		System.out.print("Enter email");
		customer.setEmail(sc.next());
		
		System.out.print("Enter phone");
		customer.setPhone(sc.next());
		
		System.out.print("Enter city");
		customer.setCity(sc.next());
		
		return customer;
	}
	
	static CustomerModel getDetails(Scanner sc){
		
			CustomerModel customer = new CustomerModel();
			System.out.print("Enter name");
			customer.setName(sc.next());
			
			System.out.print("Enter email");
			customer.setEmail(sc.next());
			
			System.out.print("Enter phone");
			customer.setPhone(sc.next());
			
			System.out.print("Enter city");
			customer.setCity(sc.next());
			
			System.out.print("Enter password");
			customer.setPassword(sc.next());
			
			return customer;
		}
	
	
	static CustomerModel getLoginDetails(Scanner sc){
		
			CustomerModel customer = new CustomerModel();
	
			System.out.print("Enter email");
			customer.setEmail(sc.next());
			
			System.out.print("Enter password");
			customer.setPassword(sc.next());
			
			return customer;
		}
	
	public static void main(String[] args) {
		
		CustomerDatabase customerData = new CustomerDatabase();
		CustomerService customerServ = new CustomerService(customerData);
		
		boolean isLogin = false;
		CustomerModel loggedInCustomer = null;
		
		try (Scanner sc = new Scanner(System.in)) {
			int choice;
			do{
				System.out.println("");
				System.out.println("Choose one of the options");
				System.out.println("1. Login");
				System.out.println("2. Get All Customers");
				System.out.println("3. Register");
				System.out.println("4. Profile");
				System.out.println("5. Edit Profile");
				System.out.println("6. Change Password");
				System.out.println("7. Exit");
				System.out.println("");

				choice = sc.nextInt();

				switch(choice) {
				case 1: 
					
					CustomerModel custo = getLoginDetails(sc);
					
					CustomerModel loginResult = customerServ.validateCredentials(custo.getEmail(), custo.getPassword());
					if(loginResult != null) {
						isLogin = true;
						loggedInCustomer = loginResult;
						System.out.println("Login Successfull !");
					} else {
						System.out.println("Email/Password is wrong !");
					}
					break;
					
				case 2: 
					List<CustomerModel> customers = new ArrayList<>();
					customers = customerServ.getAllCustomers();
					
					for(CustomerModel cust: customers) {
						System.out.print("Name- "+ cust.getName() + " ");
						System.out.print("Email- " + cust.getEmail() + " ");
						System.out.print("Phone- " + cust.getPhone() + " ");
						System.out.print("City- " + cust.getCity() + " ");
						System.out.println("");
						
					}
					break;
					
				case 3:
					CustomerModel cust = getDetails(sc);
					boolean result = customerServ.registerCustomer(cust);
					if(result) {
						System.out.println("Entry Succeffully added");
					}
					break;
					
				case 4: 
					if(!isLogin) {
						System.out.println("Please login to see profile");
					} else {
						CustomerModel customer = customerServ.getCustomerByEmail(loggedInCustomer.getEmail());
						if(customer != null) {
							System.out.println("Profile details are ===> ");
							System.out.print("Name- "+ customer.getName() + " ");
							System.out.print("Email- " + customer.getEmail() + " ");
							System.out.print("Phone- " + customer.getPhone() + " ");
							System.out.print("City- " + customer.getCity() + " ");
							System.out.println("");
						} else {
							System.out.println("No Record Found !");
						}
					}
					break;
		
				case 5:
					CustomerModel editCust = editDetails(sc);
					boolean editResult = customerServ.editCustomer(editCust, loggedInCustomer.getEmail());
					if(editResult) {
						System.out.println("Entry Updated Successfully !");
					}
					break;
					
				case 6:
					System.out.print("Enter old password");
					String oldPass = sc.next();
					
					System.out.print("Enter new password");
					String newPass = sc.next();
					
					System.out.print("Enter confirm new password");
					String confirmNewPass = sc.next();
					
					if(newPass.equals(confirmNewPass)) {
						boolean changeResult = customerServ.changeCustomerPass(oldPass, newPass, loggedInCustomer.getEmail());	
						if(changeResult) {
							System.out.println("Password Updated Successfully !");
						} else {
							System.out.println("Password Updation failed !");
						}
					} else {
						System.out.println("New password and confirm new Password are not same !");
					}
					

					break;
					
				case 7:
					
				}
			} while(choice != 7);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print(e.getMessage());
		}
	}
}
