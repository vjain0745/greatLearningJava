package services;

import java.util.ArrayList;
import java.util.List;

import databaseQueries.TaskDatabase;
import entities.Tasks;

public class TaskService {

	private TaskDatabase taskDatabase ;

	public TaskService(TaskDatabase taskDatabase) {
		// TODO Auto-generated constructor stub
		this.taskDatabase = taskDatabase;
	}


	public List<Tasks> getAllTasks(String email) throws Exception
	{
		List<Tasks> allTasks = new ArrayList<>();
		allTasks = taskDatabase.getAllTasks(email);
		if(allTasks.size() == 0)
			throw new Exception("No customers registered yet");

		return allTasks;
	}

	public boolean registerTask(Tasks task) throws Exception
	{
//		if(task.getTaskId() == null || customer.getEmail().isBlank())
//			throw new Exception("email cannot be empty or null");
		try {
			List<Tasks> allTasks = this.getAllTasks(task.getAssignedTo());
			System.out.println(allTasks.size());
			taskDatabase.insertTask(task);

		} catch (Exception e) {
		}
		
		return true;
	}
}
