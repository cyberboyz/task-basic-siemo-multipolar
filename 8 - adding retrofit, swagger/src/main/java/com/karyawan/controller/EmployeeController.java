package com.karyawan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.karyawan.exception.ResourceNotFoundException;
import com.karyawan.model.Employee;
import com.karyawan.model.EmployeeGroup;
import com.karyawan.repository.EmployeeGroupRepository;
import com.karyawan.repository.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeGroupRepository employeeGroupRepository;

    @ApiOperation(value = "${EmployeeController.getAllEmployees}")
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @ApiOperation(value = "${EmployeeController.getEmployeeById}")
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    @ApiOperation(value = "${EmployeeController.createEmployee}")
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.save(employeeDetails);
        EmployeeGroup employeeGroup = employeeGroupRepository.findById(employeeDetails.getEmployeeGroup().getId()).orElseThrow(() -> new ResourceNotFoundException("Employee group not found for this id :: " + employeeDetails.getEmployeeGroup().getId()));
        employee.setEmployeeGroup(employeeGroup);
        return ResponseEntity.ok(employee);
    }

    @ApiOperation(value = "${EmployeeController.updateEmployeePut}")
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeePut(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setAge(employeeDetails.getAge());
        EmployeeGroup employeeGroup = employeeGroupRepository.findById(employeeDetails.getEmployeeGroup().getId()).orElseThrow(() -> new ResourceNotFoundException("Employee group not found for this id :: " + employeeDetails.getEmployeeGroup().getId()));
        employee.setEmployeeGroup(employeeGroup);
        employee.setName(employeeDetails.getName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @ApiOperation(value = "${EmployeeController.updateEmployeePatch}")
    @PatchMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployeePatch(@PathVariable(value = "id") Long employeeId,
                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        if (employeeDetails.getAge() != 0)
            employee.setAge(employeeDetails.getAge());
        if (employeeDetails.getEmployeeGroup() != null) {
            EmployeeGroup employeeGroup = employeeGroupRepository.findById(employeeDetails.getEmployeeGroup().getId()).orElseThrow(() -> new ResourceNotFoundException("Employee group not found for this id :: " + employeeDetails.getEmployeeGroup().getId()));
            employee.setEmployeeGroup(employeeGroup);
        }
        if (employeeDetails.getName() != null)
            employee.setName(employeeDetails.getName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @ApiOperation(value = "${EmployeeController.deleteEmployee}")
    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}