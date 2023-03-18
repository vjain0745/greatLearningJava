package services;

import databaseQueries.UserDatabase;
import entities.Users;

public class UserService {
	
	private UserDatabase userDatabase ;

	public UserService(UserDatabase userDatabase) {
		// TODO Auto-generated constructor stub
		this.userDatabase = userDatabase;
	}

	public Users validateCredentials(String email, String password) throws Exception
	{
		if(email==null || email.isEmpty())
			throw new Exception("email cannot be empty or null");
		
		return this.userDatabase.login(email, password);
	}
}
