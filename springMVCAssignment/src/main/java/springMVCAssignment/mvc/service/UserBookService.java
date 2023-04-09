package springMVCAssignment.mvc.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springMVCAssignment.mvc.database.UsersBookDatabase;
import springMVCAssignment.mvc.entity.Books;
import springMVCAssignment.mvc.entity.Users;
import springMVCAssignment.mvc.entity.UsersBook;

@Service
public class UserBookService {
	
	@Autowired
	private UsersBookDatabase database;
	
	public boolean saveUserBook(UsersBook dto) throws Exception {
		boolean user = this.database.saveUsersBook(dto);
		System.out.println("userr-> " +  user);
		if (user) {
			return true;			
		}
		
		return false;
	}

	public List<UsersBook> getAllUsersBookReadLater(String email) {
		Users user = new Users();
		user.setEmail(email);
		List<UsersBook> usersBook = this.database.getAllUsersBookReadLater(user);
		return usersBook;
	}
	
	public List<UsersBook> getAllUserBooksLiked(String email) {
		Users user = new Users();
		user.setEmail(email);
		List<UsersBook> usersBook = this.database.getAllUsersBookLiked(user);
		return usersBook;
	}
}
