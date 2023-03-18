package services;

import java.util.*;
import databases.CustomerDatabase;
import models.CustomerModel;

public class CustomerService {

	private CustomerDatabase customerDatabase ;

	public CustomerService(CustomerDatabase customerDatabase) {
		// TODO Auto-generated constructor stub
		this.customerDatabase = customerDatabase;
	}


	public List<CustomerModel> getAllCustomers() throws Exception
	{
		List<CustomerModel> allCustomers = new ArrayList<>();
		allCustomers = customerDatabase.getAllCustomers();
		if(allCustomers.size() == 0)
			throw new Exception("No customers registered yet");

		return allCustomers;
	}

	public boolean registerCustomer(CustomerModel customer) throws Exception
	{
		if(customer.getEmail() == null || customer.getEmail().isBlank())
			throw new Exception("email cannot be empty or null");
		try {
			customerDatabase.insertCustomer(customer);

		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean editCustomer(CustomerModel customer, String email) throws Exception
	{
		if(email == null || email.isBlank())
			throw new Exception("email cannot be empty or null");
		try {
			customerDatabase.updateCustomer(customer, email);

		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public boolean changeCustomerPass(String oldPass, String newPass, String email) throws Exception
	{
		if(oldPass == null || newPass.isBlank() || newPass == null)
			throw new Exception("All fields are mandatory !");
		try {
			customerDatabase.changePasswordCustomer(oldPass, newPass, email);

		} catch (Exception e) {
			return false;
		}
		
		return true;
	}
	
	public CustomerModel getCustomerByEmail(String email) throws Exception
	{
		if(email==null || email.isEmpty())
			throw new Exception("email cannot be empty or null");
		CustomerModel cust = this.customerDatabase.getCustomerByEmail(email);
		if(cust == null)
			throw new Exception("Customer with email "+email+" does not exist");
		return cust;
	}

	public CustomerModel validateCredentials(String email, String password) throws Exception
	{
		if(email==null || email.isEmpty())
			throw new Exception("email cannot be empty or null");
		
		return this.customerDatabase.login(email, password);
	}
}


