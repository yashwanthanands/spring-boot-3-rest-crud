package com.yash.dev.dao;

import com.yash.dev.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
