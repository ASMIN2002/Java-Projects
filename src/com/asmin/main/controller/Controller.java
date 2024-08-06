package com.asmin.main.controller;

import java.util.Scanner;

public class Controller {
	Scanner scanner = new Scanner(System.in);
	
	public Controller() {
		System.out.println();
		System.out.println("1. ADD EMPLOYEE");
		System.out.println("2. SEARCH EMPLOYEE");
		System.out.println("3. UPDATE EMPLOYEE");
		System.out.println("4. DELETE EMPLOYEE");
		System.out.println("5. EXIT");
		System.out.println();
		System.out.print("CHOOSE OPTION  : ");
		int choice = scanner.nextInt();
		ControllerImpl controllerImpl = new ControllerImpl();
		switch(choice) {
		case 1:
			controllerImpl.add();
			new Controller();
			break;
		case 2:
			controllerImpl.search();
			new Controller();
			break;
		case 3:
			controllerImpl.update();
			new Controller();
			break;
		case 4:
			controllerImpl.delete();
			new Controller();
			break;
		case 5:
			System.err.println("THANK YOU");
			System.exit(0);
		default:
			System.out.println("Please Enter Number in Between 1 to 5");	
			break;
		}
	}
}
