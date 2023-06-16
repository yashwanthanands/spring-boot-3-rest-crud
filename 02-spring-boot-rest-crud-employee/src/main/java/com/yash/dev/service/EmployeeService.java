package com.yash.dev.service;

import com.yash.dev.entity.Employee;
import java.util.List;

/**
 * @author yashwanthanands
 */
public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void delete(int id);

}
