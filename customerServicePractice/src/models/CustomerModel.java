package models;

public class CustomerModel {

	private String name;
	private String phone;
	private String email;
	private String city;
	private String password;
	
	public CustomerModel(String name, String phone, String email, String city, String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.password = password;
	}

	public CustomerModel() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
