package com.desire.repository;

import com.desire.model.Employee;

import java.util.List;

public interface EmployeeDao {
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long employeeId);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long employeeId);
}
