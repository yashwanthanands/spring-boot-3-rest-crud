package com.yash.dev.controller;

import com.yash.dev.dao.EmployeeDAO;
import com.yash.dev.entity.Employee;
import com.yash.dev.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yashwanthanands
 */

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    public EmployeeRestController(EmployeeService empService) {
        employeeService=empService;
    }

    //Add mapping for Get All Employees from DB
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    //Add mapping for Get Employee Details by Employee ID
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null) {
            throw new RuntimeException("Employee Id not found "+employeeId);
        }
        return theEmployee;
    }

    //Add mapping for post Employee Details to DB
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        Employee dbEmployee =employeeService.save(theEmployee);
        return dbEmployee;
    }

    //Add mapping for update Employee Details to DB
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee =employeeService.save(theEmployee);
        return dbEmployee;
    }

    //Add mapping for delete Employee Details by Id
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId) {
        Employee theEmployee=employeeService.findById(employeeId);
        if(theEmployee == null) {
            throw new RuntimeException("Employee Id not found "+employeeId);
        }
        employeeService.delete(employeeId);
    }
}
