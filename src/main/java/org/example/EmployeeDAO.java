package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    // Data Access Object (add/get/remove)
    // Add Employee
    public static void addEmployee(Employee e) {
        String sql = "INSERT INTO employees (name, clearance_level) VALUES (?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, e.getEmployeeName());
                ps.setString(2, e.getEmployeeLevel());
                ps.executeUpdate();
                System.out.println("Employee Added");
        } catch (SQLException ex) {
                System.out.println("Failed to add : " + ex.getMessage());
        }
    }

    // Get all employees
    public static List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("clearance_level")
                ));
            }
        } catch (SQLException ex) {
            System.out.println("Failed to fetch : " + ex.getMessage());
        }
        return list;
    }

    // Delete Employee
    public static void removeEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        try (Connection conn = DatabaseManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) System.out.println("Employee Removed.");
            else System.out.println("No Employee with that ID");
        } catch (Exception ex) {
            System.out.println("Failed to remove : " + ex.getMessage());
        }
    }
}
