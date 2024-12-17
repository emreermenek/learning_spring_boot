package com.example.springboot.cruddemo.rest;

import com.example.springboot.cruddemo.entity.Employee;
import com.example.springboot.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeID}")
    public Employee findEmployeeByID(@PathVariable int employeeID){
        Employee employee = employeeService.findByID(employeeID);
        if(employee == null){
            throw new RuntimeException("Employee not found!");
        }
        return employee;
    }

    // add mapping for POST employees - add new employee

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // we want to set id to 0 because we want to force add
        // even the same data exist...
        employee.setId(0);
        Employee addedEmployee = employeeService.save(employee);
        return addedEmployee;
    }

    // add mapping for PUT employee - update new employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee updatedEmployee = employeeService.save(employee);
        return updatedEmployee;
    }

    // add mapping for DELETE employee by id - delete an employee

    @DeleteMapping("/employees/{employeeID}")
    public String deleteEmployee(@PathVariable int employeeID){
        Employee employee = employeeService.findByID(employeeID);
        if(employee == null){
            throw new RuntimeException("No employee exist with given id!");
        }
        employeeService.deleteByID(employeeID);

        return "Deleted employee id - " + employeeID;
    }
}
