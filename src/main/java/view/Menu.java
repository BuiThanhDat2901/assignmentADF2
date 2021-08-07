package view;

import java.util.Scanner;

import controller.EmployeeController;
import model.EmployeeModel;

public class Menu {
	public static void menu() {
		System.out.println("--------------------");
		System.out.println("EMPLOYEE MANAGER");
		System.out.println("1.Login");
		System.out.println("2.Register");
		System.out.println("3.Exit");
		System.out.println("--------------------");
	}	
	public static void start() {
		Scanner scanner = new Scanner(System.in);
		EmployeeModel employeeModel = new EmployeeModel();
		while (true) {
			view.Menu.menu();
			System.out.println("Your choice:");
			int key = Integer.parseInt(scanner.nextLine());
			switch (key) {
			case 1:
				EmployeeController.login();
				break;
			case 2:
				EmployeeController.register();
				break;
			case 3:
				System.out.println("Bye");
				System.exit(0);
				break;
			default:
				System.out.println("Try again!");
			}
		}
	}
	

}
