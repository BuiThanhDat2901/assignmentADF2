package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.EmployeeController;
import entity.Employee;

public class EmployeeModel {

	public static boolean register(Employee emp) {

		try {
			String sql = "insert into employees (name,address,email,username,password,datecreate,dateupdate,status) values (?,?,?,?,?,?,?,?)";
			Connection cnn = util.ConnectionHelper.getConnection();
			PreparedStatement pp = cnn.prepareStatement(sql);
			pp.setString(1, emp.getName());
			pp.setString(2, emp.getAddress());
			pp.setString(3, emp.getEmail());
			pp.setString(4, emp.getUserName());
			pp.setString(5, emp.getPassWord());
			pp.setTimestamp(6, new java.sql.Timestamp(emp.getDateCreate().getTime()));
			pp.setTimestamp(7, new java.sql.Timestamp(emp.getDateUpdate().getTime()));
			pp.setInt(8, emp.getStatus());
			pp.execute();
			
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			return false;

		}

	}

	public static boolean checkExitsAccount(String account) {
		try {
			String sql = "select * from employees ";
			Connection cnn = util.ConnectionHelper.getConnection();
			PreparedStatement stmt = cnn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).trim().equals(account.trim())) {
					return true;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static Employee login(String username, String password) {
		try {
			String sql = "select * from employees where username = ? and password = ? ";
			Connection cnn = util.ConnectionHelper.getConnection();

			PreparedStatement stmt = cnn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			Employee employee = new Employee();
			if (rs.next()) {

				employee.setName(rs.getString(1));
				employee.setAddress(rs.getString(2));
				employee.setEmail(rs.getString(3));
				employee.setUserName(rs.getString(4));
				employee.setPassWord(rs.getString(5));
				employee.setDateCreate(rs.getDate(6));
				employee.setDateUpdate(rs.getDate(7));
				employee.setStatus(rs.getInt(8));

			}
			if (employee.getUserName() != null) {
				System.out.println("Login Success");
				EmployeeController.output(employee);
			} else {
				System.out.println("Login Fail");
			}
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return null;

	}

}
