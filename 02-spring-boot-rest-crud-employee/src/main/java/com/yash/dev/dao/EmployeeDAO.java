package com.yash.dev.dao;

import com.yash.dev.entity.Employee;
import java.util.List;

/**
 * @author yashwanthanands
 */
public interface EmployeeDAO {

    List<Employee> findAll();

}
