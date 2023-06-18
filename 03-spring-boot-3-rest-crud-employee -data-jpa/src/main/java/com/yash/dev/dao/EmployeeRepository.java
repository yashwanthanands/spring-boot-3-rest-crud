package com.yash.dev.dao;

import com.yash.dev.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yashwanthanands
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
