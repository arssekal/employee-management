package com.arssekal.employee_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arssekal.employee_backend.dto.EmployeeDto;
import com.arssekal.employee_backend.service.EmployeeService;

import lombok.AllArgsConstructor;

@CrossOrigin("*")
@AllArgsConstructor
@Controller
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // add amployee rest api 
    @PostMapping("/add-employee")
    public ResponseEntity<EmployeeDto> createEmployeeDto(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmplyee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmplyee, HttpStatus.CREATED);
    }
    // get employee rest api
    @GetMapping("/get-employee/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeDto(@PathVariable Long id) {
        EmployeeDto savedEmplyee = employeeService.getEmployee(id);
        return ResponseEntity.ok(savedEmplyee);
    }
    // get all employees rest api
    @GetMapping("/get-all")
    public ResponseEntity<List<EmployeeDto>> getEmployeeDto() {
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    // update employee rest api
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto updatedEmployee) {
        EmployeeDto savedEmployee = employeeService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(savedEmployee);
    }
    // delete employee rest api
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long id) {
        EmployeeDto savedEmployee = employeeService.deleteEmployee(id);
        return ResponseEntity.ok(savedEmployee);
    }
}
