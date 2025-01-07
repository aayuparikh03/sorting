package com.example.repository;

import com.example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Method with Sort Parameter
    List<Employee> findAll(Sort sort);

    // Custom Query with Sorting
    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeesBySalaryGreaterThan(@Param("salary") Double salary,
                                                    Sort sort);
}
