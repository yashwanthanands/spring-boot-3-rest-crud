package com.yash.dev.service;

import com.yash.dev.dao.EmployeeRepository;
import com.yash.dev.entity.Employee;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yashwanthanands
 */

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository empRepository) {
        employeeRepository=empRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee tempEmployee=null;
        if(result.isPresent()) {
            tempEmployee=result.get();
        } else {
            throw new RuntimeException("Employee ID not found "+id);
        }
        return tempEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
