package com.bdlz.jdbc;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class EmployeePayRollDBServices {
    Employee employee = new Employee();

    public static void main(String[] args) throws SQLException {
        EmployeePayrollService employeePayrollService = new EmployeePayrollService();
        employeePayrollService.getConnection();
        employeePayrollService.insertData();
        employeePayrollService.retrieveData();
        employeePayrollService.updateSalary();
    }

    private void retrieveData() throws SQLException {
        List<EmployeeInfo> employeeInfoList = employee.retrieveData();
        System.out.println(employeeInfoList);
    }


    private void getConnection() {
        Employee.getConnection();
    }

    private void updateSalary() {
        Employee.updateSalary(9,9000);
    }

    private void insertData() {
        EmployeeInfo employeeInfo= new EmployeeInfo();
        employeeInfo.setName("Rama krishna");
        employeeInfo.setGender('M');
        employeeInfo.setAddress("Vijayawada");
        employeeInfo.setPhone("8799877987");
        employeeInfo.setStartDate(LocalDate.now());
        Employee employeeRepo=new Employee();
        employeeRepo.insertData(employeeInfo);
    }
}
