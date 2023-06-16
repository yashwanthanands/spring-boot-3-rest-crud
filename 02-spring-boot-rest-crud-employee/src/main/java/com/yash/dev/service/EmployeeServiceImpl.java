package com.yash.dev.service;

import com.yash.dev.dao.EmployeeDAO;
import com.yash.dev.entity.Employee;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yashwanthanands
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO empDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        empDAO=employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return empDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return empDAO.findById(id);
    }

    @Override
    public Employee save(Employee theEmployee) {
        return empDAO.save(theEmployee);
    }

    @Override
    public void delete(int id) {
       empDAO.delete(id);
    }
}
