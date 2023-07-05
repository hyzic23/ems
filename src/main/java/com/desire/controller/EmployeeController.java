package com.desire.controller;
import com.desire.model.Employee;
import com.desire.repository.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeDao.getAllEmployees();
    }

    @PostMapping("employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeDao.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeDao.getEmployeeById(id);
        return new ResponseEntity(employee, HttpStatus.OK);
    }

    @PutMapping("/empoloyee/{id}}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee)
    {
        employee.setId(id);
        Employee updatedEmployee = employeeDao.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long employeeId)
    {
        employeeDao.deleteEmployee(employeeId);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}
