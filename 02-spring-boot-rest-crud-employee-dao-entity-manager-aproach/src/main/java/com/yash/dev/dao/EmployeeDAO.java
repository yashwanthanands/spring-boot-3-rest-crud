package com.yash.dev.dao;

import com.yash.dev.entity.Employee;
import java.util.List;

/**
 * @author yashwanthanands
 */
public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee theEmployee);

    void delete(int id);

}
