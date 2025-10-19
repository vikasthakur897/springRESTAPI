package com.server.store.service;

import java.util.List;

import com.server.store.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployes(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);
}
