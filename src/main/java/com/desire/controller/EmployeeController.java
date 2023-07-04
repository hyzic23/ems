package com.desire.controller;

import com.desire.exception.ResourceNotFoundException;
import com.desire.model.Employee;
import com.desire.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

//    @GetMapping("/employee/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
//        Optional<Employee> employee = employeeRepository.findById(id);
//                            //.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with : " + id));
//        return ResponseEntity<Optional<Employee>>.ok(employee);
//    }@GetMapping("/employee/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
//        Optional<Employee> employee = employeeRepository.findById(id);
//                            //.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with : " + id));
//        return ResponseEntity<Optional<Employee>>.ok(employee);
//    }


}
