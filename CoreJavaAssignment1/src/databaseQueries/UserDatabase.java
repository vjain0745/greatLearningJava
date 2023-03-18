package databaseQueries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connections.SqlConnection;
import entities.Users;

public class UserDatabase {

	Connection conn = SqlConnection.getConnection();
	List<Users> users = new ArrayList<>();

	public List<Users> getAllUsers() {
		String sql = "select * from users";
		users = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Users u1 = new Users();
				u1.setUserName(rs.getString("name"));
				u1.setEmail(rs.getString("email"));
				u1.setPassword(rs.getString("password"));
				users.add(u1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public Users getUserByEmail(String email) {
		String sql = "select * from users where email = '" + email + "';";

		Users user = new Users();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				user.setUserName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	public Users login(String email, String password) {
		this.getAllUsers();
		for (Users c : users) {
			if (c.getEmail().equals(email)) {
				if (c.getPassword().equals(password))
					return c;
			}
		}

		return null;
	}

}
