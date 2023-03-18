package ui;

import databaseQueries.UserDatabase;

import java.util.List;
import java.util.Scanner;

import databaseQueries.TaskDatabase;
import entities.Users;
import entities.Tasks;
import services.TaskService;
import services.UserService;

public class Starterr {

	public static void main(String[] args) {

		UserDatabase userData = new UserDatabase();
		UserService userServ = new UserService(userData);

		TaskDatabase taskData = new TaskDatabase();
		TaskService taskServ = new TaskService(taskData);

		boolean isLogin = false;
		Users loggedInUser = null;

		int choice = -1;
		
		do {
			try (Scanner sc = new Scanner(System.in)) {

				System.out.println("1. Login");
				System.out.println("0. Exit");

				choice = sc.nextInt();

				switch (choice) {
				case 0:
					break;

				case 1:

					System.out.println("Please enter email");
					String email = sc.next();
					System.out.println("Please enter password");
					String password = sc.next();

					loggedInUser = userServ.validateCredentials(email, password);
					System.out.println(loggedInUser);
					if (loggedInUser != null) {
						isLogin = true;
						int internalChoice = -1;

						do {
							System.out.println("1. Get All Tasks");
							System.out.println("2. Create A New task");
							System.out.println("3. Log Out");

							internalChoice = sc.nextInt();

							switch (internalChoice) {
							case 3:
								break;

							case 1:
								List<Tasks> allTasks = taskServ.getAllTasks(loggedInUser.getEmail());

								for (Tasks task : allTasks) {
									System.out.println(task);
								}

								break;
							case 2:

								System.out.println("Please enter task title");
								String taskTitle = sc.next();
								System.out.println("Please enter task text");
								String taskText = sc.next();

								Tasks newTask = new Tasks();

								newTask.setTaskTitle(taskTitle);
								newTask.setTaskTitle(taskText);
								newTask.setAssignedTo(loggedInUser.getEmail());

								boolean isSaved = taskServ.registerTask(newTask);
								if (isSaved) {
									System.out.println("Details Saved Successfully !");
								}

								break;
							default:
								break;
							}
						} while (internalChoice != 3);

					} else {
						System.out.println("Invalid UserName/Password");
					}

					break;

				default:
					break;
				}
				
				choice = -1;

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (choice != 0);

	}

}