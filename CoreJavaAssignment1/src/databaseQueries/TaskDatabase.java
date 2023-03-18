package databaseQueries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connections.SqlConnection;

import entities.Tasks;

public class TaskDatabase {

	Connection conn = SqlConnection.getConnection();
	List<Tasks> tasks = new ArrayList<>();

	public List<Tasks> getAllTasks(String email) {
		String sql = "select * from tasks where email='" +email+"'" ;
		tasks = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Tasks t1 = new Tasks();
				t1.setTaskId(rs.getInt("taskId"));
				t1.setTaskTitle(rs.getString("taskTitle"));
				t1.setTaskText(rs.getString("taskText"));
				t1.setAssignedTo(rs.getString("assignedTo"));
				tasks.add(t1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tasks;
	}

	public boolean insertTask(Tasks task) throws Exception {
		String sql = "insert into tasks values (?,?,?,?,?)";
		tasks = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, task.getTaskId());
			statement.setString(2, task.getTaskText());
			statement.setString(3, task.getTaskTitle());
			statement.setString(4, task.getAssignedTo());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

	public boolean updateTask(Tasks task, int taskId) throws Exception {
		String sql = "update customer set taskId=?, taskTitle=?, taskText=?, assignedTo=? where taskId = '" + taskId
				+ "';";
		System.out.println(sql);
		tasks = new ArrayList<>();
		try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, task.getTaskId());
			statement.setString(2, task.getTaskText());
			statement.setString(3, task.getTaskTitle());
			statement.setString(4, task.getAssignedTo());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
	}

}
