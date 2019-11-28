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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class EmployeeGroupController {
    @Autowired
    private EmployeeGroupRepository employeeGroupRepository;

    @GetMapping("/employee_groups")
    public List<EmployeeGroup> getAllEmployeeGroups() {
        return employeeGroupRepository.findAll();
    }

    @GetMapping("/employee_groups/{id}")
    public ResponseEntity<EmployeeGroup> getEmployeeGroupById(@PathVariable(value = "id") Long employeeGroupId)
            throws ResourceNotFoundException {
        EmployeeGroup employeeGroup = employeeGroupRepository.findById(employeeGroupId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee group not found for this id :: " + employeeGroupId));
        return ResponseEntity.ok().body(employeeGroup);
    }

    @PostMapping("/employee_groups")
    public EmployeeGroup createEmployee(@Valid @RequestBody EmployeeGroup employeeGroup) {
        return employeeGroupRepository.save(employeeGroup);
    }

    @PutMapping("/employee_groups/{id}")
    public ResponseEntity<EmployeeGroup> updateEmployeeGroup(@PathVariable(value = "id") Long employeeGroupId,
                                                   @Valid @RequestBody EmployeeGroup employeeGroupDetails) throws ResourceNotFoundException {
        EmployeeGroup employeeGroup = employeeGroupRepository.findById(employeeGroupId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee group not found for this id :: " + employeeGroupId));

        employeeGroup.setName(employeeGroupDetails.getName());
        employeeGroup.setMonthlySalary(employeeGroupDetails.getMonthlySalary());
        final EmployeeGroup updatedEmployeeGroup = employeeGroupRepository.save(employeeGroup);
        return ResponseEntity.ok(updatedEmployeeGroup);
    }

    @DeleteMapping("/employee_groups/{id}")
    public Map<String, Boolean> deleteEmployeeGroup(@PathVariable(value = "id") Long employeeGroupId)
            throws ResourceNotFoundException {
        EmployeeGroup employeeGroup = employeeGroupRepository.findById(employeeGroupId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeGroupId));

        employeeGroupRepository.delete(employeeGroup);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}