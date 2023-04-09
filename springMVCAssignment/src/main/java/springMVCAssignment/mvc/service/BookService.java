package springMVCAssignment.mvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springMVCAssignment.mvc.database.BookDatabase;
import springMVCAssignment.mvc.database.UsersDatabase;
import springMVCAssignment.mvc.dto.LoginDto;
import springMVCAssignment.mvc.entity.Books;
import springMVCAssignment.mvc.entity.Users;

@Service
public class BookService {
	
	@Autowired
	private BookDatabase database;
	
	public boolean saveBook(Books dto) throws Exception {
		boolean user = this.database.saveBooks(dto);
		System.out.println("userr-> " +  user);
		if (user) {
			return true;			
		}
		
		return false;
	}

	public Books getBookById(String bookId) throws Exception {

		Books book = this.database.getBookById(bookId);

		return book;

	}

	public List<Books> getAllBooks() {
		List<Books> books = this.database.getAllBooks();
		return books;

	}
}
