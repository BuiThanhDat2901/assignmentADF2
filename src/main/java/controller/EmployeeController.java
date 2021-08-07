package controller;

import java.util.Date;
import java.util.Scanner;

import model.EmployeeModel;
import entity.Employee;

public class EmployeeController {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Username");
        String username = scanner.nextLine();
        System.out.println("Password");
        String password = scanner.nextLine();
        EmployeeModel.login(username, password);
    }

    public static void register() {
        Employee employee = new Employee();
        EmployeeModel employeeModel = new EmployeeModel();
        employee = input();
        if (employeeModel.register(employee)) {
            System.out.println("Register success");
            output(employee);
        } else {
            System.out.println("Register fail");
        }

    }

    public static Employee input() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter information below to register:");
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Address:");
        String address = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Username:");
        String userName = scanner.nextLine();
        while (EmployeeModel.checkExitsAccount(userName)) {
            System.out.println("Account already exists!");
            userName = scanner.nextLine();
        }
        System.out.println("Password:");
        String passWord = scanner.nextLine();

        long millis = System.currentTimeMillis();
        Date dateCreate = new java.util.Date(millis);
        System.out.println("DateCreate" + util.DateTimeUtil.formatDateToString(dateCreate));
        System.out.println("DateUpdate");
        java.util.Date date2 = util.DateTimeUtil.parseDateString(scanner.nextLine());

        Date dateUpdate = date2;
        System.out.println("Status");
        int status = Integer.parseInt(scanner.nextLine());
        return new Employee(name, address, email, userName, passWord, dateCreate, dateUpdate, status);
    }

    public static void output(Employee e) {
        System.out.println("____________________");
        System.out.println("Account Information");
        System.out.println("____________________");
        System.out.println("Name: " + e.getName());
        System.out.println("Address: " + e.getAddress());
        System.out.println("Email: " + e.getEmail());
        System.out.println("UserName: " + e.getUserName());
        System.out.println("PassWord: " + e.getPassWord());
        System.out.println("Date Create: " + e.getDateCreate());
        System.out.println("Date Update: " + e.getDateUpdate());
        System.out.println("Status: " + e.getStatus());
        System.out.println("____________________");
    }
}
