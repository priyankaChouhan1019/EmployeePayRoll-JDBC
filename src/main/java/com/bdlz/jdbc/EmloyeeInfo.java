package com.bdlz.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmloyeeInfo {
    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/payroll_service";
        String username = "root";
        String password = "rootpassword";
        Connection connection = null;
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");
        } catch (
                SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }

    public void insertData(EmployeeInfo info) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "insert into employee(name,gender,startDate,phone,address) " +
                    "values ('" + info.getName() + "','" + info.getGender() + "'," +
                    "'" + info.getStartDate() + "','" + info.getPhone() + "'," +
                    "'" + info.getAddress() + "'); ";
            int result = statement.executeUpdate(sql);
            if (result == 1) {
                System.out.println("Query inserted");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<EmployeeInfo> retrieveData() {
        ResultSet resultSet = null;
        List<EmployeeInfo> employeeInfoList = new ArrayList<>();
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "select * from employee";
            resultSet = statement.executeQuery(sql);
            int count = 1;
            while (resultSet.next()) {
                count++;
                EmployeeInfo employeeInfo = new EmployeeInfo();
                employeeInfo.setId(resultSet.getInt("id"));
                employeeInfo.setName(resultSet.getString("name"));
                employeeInfo.setGender(resultSet.getString("gender").charAt(0));
                employeeInfo.setStartDate(resultSet.getDate("startDate").toLocalDate());
                employeeInfoList.add(employeeInfo);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return employeeInfoList;
    }

    public static void updateSalary(int id, int salary) {
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            String query = "update employee set salary=" + salary + " where id=" + id + "";
            int result = statement.executeUpdate(query);
            if (result == 1)
                System.out.println("salary updated");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
