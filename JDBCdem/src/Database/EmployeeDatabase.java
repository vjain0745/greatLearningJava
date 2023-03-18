package Database;

import Entity.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {

	Connection conn = DbConnection.getConnection();

	public List<Employee> getAllEmployees() {
		String sql = "select * from employee";
		List<Employee> emps = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				Employee e1 = new Employee();
				e1.setEmail(rs.getString("email"));
				e1.setName(rs.getString("name"));
				e1.setPhone(rs.getString("phone"));
				emps.add(e1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emps;
	}
}
