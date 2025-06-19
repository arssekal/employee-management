package com.arssekal.employee_backend.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arssekal.employee_backend.dto.EmployeeDto;
import com.arssekal.employee_backend.entity.Employee;
import com.arssekal.employee_backend.exception.EmployeeNotFoundException;
import com.arssekal.employee_backend.mapper.EmployeeMapper;
import com.arssekal.employee_backend.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee =employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto getEmployee(Long id) {
        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new EmployeeNotFoundException("the employee not found with the given id: "+ id));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }
    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employees = employeeRepository
                                      .findAll()
                                      .stream()
                                      .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                                      .collect(Collectors.toList());
        return employees;
    }
    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto updatedEmployee) {
        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new EmployeeNotFoundException("the employee not found with the given id: "+ id));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee savedEmployee = employeeRepository.save(employee);
        
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
    @Override
    public EmployeeDto deleteEmployee(Long id) {
        Employee employee = employeeRepository
                            .findById(id)
                            .orElseThrow(() -> new EmployeeNotFoundException("the employee not found with the given id: "+ id));
        employeeRepository.delete(employee);
        return EmployeeMapper.mapToEmployeeDto(employee);
    }


}
