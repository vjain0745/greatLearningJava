package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import connections.SqlConnection;
import models.CustomerModel;

public class CustomerDatabase {

	Connection conn = SqlConnection.getConnection();
	List<CustomerModel> customers = new ArrayList<>();

	public List<CustomerModel> getAllCustomers() {
		String sql = "select * from customer";
		customers = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				CustomerModel e1 = new CustomerModel();
				e1.setName(rs.getString("name"));
				e1.setEmail(rs.getString("email"));
				e1.setPhone(rs.getString("phone"));
				e1.setCity(rs.getString("city"));
				e1.setPassword(rs.getString("password"));
				customers.add(e1);
			}
		} catch (SQLException e) {
			
		}
		
		return customers;
	}
	
	public boolean insertCustomer(CustomerModel customer) throws Exception
	{
		String sql = "insert into customer values (?,?,?,?,?)";
		customers = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmail());
			statement.setString(3, customer.getPhone());
			statement.setString(4, customer.getCity());
			statement.setString(5, customer.getPassword());

			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean updateCustomer(CustomerModel customer, String email) throws Exception
	{
		String sql = "update customer set name=?, email=?, phone=?, city=? where email = '"+email+"';";
		System.out.println(sql);
		customers = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, customer.getName());
			statement.setString(2, customer.getEmail());
			statement.setString(3, customer.getPhone());
			statement.setString(4, customer.getCity());

			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean changePasswordCustomer(String oldPass, String newPass, String email) throws Exception
	{
		String sql = "select * from customer where email = '"+email+"';";

		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			String password = "";
			while (rs.next()) {				
				password = rs.getString("password");
			}
			
			if(password.equals(oldPass)) {
				sql = "update customer set password=? where email = '"+email+"';";
				customers = new ArrayList<>();
				try {
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, newPass);
					st.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				throw new Exception("Old password is wrong !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return true;
	}
	
	public CustomerModel getCustomerByEmail(String email)
	{
		String sql = "select * from customer where email = '"+email+"';";

		CustomerModel customer = new CustomerModel();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {				
				customer.setName(rs.getString("name"));
				customer.setEmail(rs.getString("email"));
				customer.setPhone(rs.getString("phone"));
				customer.setCity(rs.getString("city"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return customer;
	}

	public CustomerModel login(String email, String password)
	{
		this.getAllCustomers();		
		for(CustomerModel c : customers)
		{
			if(c.getEmail().equals(email))
			{
				if(c.getPassword().equals(password))
					return c;
			}
		}
		
		return null;
	}
	
}
