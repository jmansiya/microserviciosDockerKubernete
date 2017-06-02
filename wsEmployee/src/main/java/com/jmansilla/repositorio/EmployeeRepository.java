package com.jmansilla.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.jmansilla.modelo.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String>, QueryDslPredicateExecutor<Employee> {

}
