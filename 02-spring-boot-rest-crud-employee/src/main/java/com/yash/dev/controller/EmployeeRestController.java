package com.yash.dev.controller;

import com.yash.dev.dao.EmployeeDAO;
import com.yash.dev.entity.Employee;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yashwanthanands
 */

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO empDAO) {
        employeeDAO=empDAO;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }

}
