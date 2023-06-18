package com.yash.dev.dao;

import com.yash.dev.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author yashwanthanands
 */

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //setup constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager theEntityManager) {
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery= entityManager.createQuery("from Employee", Employee.class);

        //execute query and get result list
        List<Employee> employees=theQuery.getResultList();

        //return the results
        return employees;
    }

    @Override
    public Employee findById(int id) {
        //get employee
        Employee emp=entityManager.find(Employee.class,id);

        //return employee
        return emp;
    }

    @Override
    public Employee save(Employee theEmployee) {
        //save employee
        Employee emp=entityManager.merge(theEmployee);

        //return saved employee
        return emp;
    }

    @Override
    public void delete(int id) {
        //find employee by id
        Employee emp=entityManager.find(Employee.class,id);

        //delete the employee
        entityManager.remove(emp);
    }
}
