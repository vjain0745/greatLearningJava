package springMVCAssignment.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVCAssignment.mvc.database.UsersDatabase;
import springMVCAssignment.mvc.dto.LoginDto;
import springMVCAssignment.mvc.entity.Users;

@Service
public class UserService {

	@Autowired
	private UsersDatabase database;

	public boolean validateUser(LoginDto dto) throws Exception {
		if (this.database.loginUser(dto))
			return true;
		return false;
	}
	
	public boolean saveUser(Users dto) throws Exception {
		boolean user = this.database.saveUser(dto);
		System.out.println("userr-> " +  user);
		if (user) {
			return true;			
		}
		
		return false;
	}

	public Users getUserByEmail(String email) throws Exception {

		Users user = this.database.getUserById(email);
		return user;

	}

	public List<String> getAllUsersEmail() {
		List<Users> users = this.database.getAllUsers();
		List<String> useremail = new ArrayList<String>();
		users.forEach(user -> useremail.add(user.getEmail()));
		return useremail;

	}
}
