package com.example.service;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Fetch all employees sorted by a field
    public List<Employee> getAllEmployeesSorted(String sortBy, String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return employeeRepository.findAll(sort);
    }

    // Fetch employees with dynamic sorting based on salary
    public List<Employee> getEmployeesBySalary(Double salary, String sortBy,
                                               String direction) {
        Sort sort = direction.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        return employeeRepository.findEmployeesBySalaryGreaterThan(salary, sort);
    }

}
