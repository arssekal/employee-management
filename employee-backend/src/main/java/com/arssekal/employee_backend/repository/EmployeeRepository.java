package com.arssekal.employee_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arssekal.employee_backend.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
