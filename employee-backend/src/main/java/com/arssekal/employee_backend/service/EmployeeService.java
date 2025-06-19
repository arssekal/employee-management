package com.arssekal.employee_backend.service;

import java.util.List;
import com.arssekal.employee_backend.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee);
    EmployeeDto deleteEmployee(Long id);
}
