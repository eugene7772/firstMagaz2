package com.magaz2.firstMagaz2.service;

import com.magaz2.firstMagaz2.Entity.Employee;
import com.magaz2.firstMagaz2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(Long id){
        return employeeRepository.findById(id);
    }
}
