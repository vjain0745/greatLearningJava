package Entity;

public class Employee {

	String email;
	String name;
	String phone;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
	
	public Employee(String email, String name, String phone) {
		this.email = email;
		this.name = name;
		this.phone = phone;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	

	
}
