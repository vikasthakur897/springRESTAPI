package com.server.store.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.server.store.dto.EmployeeDto;
import com.server.store.entity.Employess;
import com.server.store.exception.ResourceNotFound;
import com.server.store.mapper.EmployeeMapper;
import com.server.store.repository.EmployeeRepository;
import com.server.store.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployes(EmployeeDto employeeDto) {
       
        Employess employess = EmployeeMapper.mapToEmployee(employeeDto);
        
        Employess savedEmployee = employeeRepository.save(employess);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

      Employess employess =  employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employess);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

      List<Employess> employess =  employeeRepository.findAll();
      return employess.stream()
                .map((employes) -> EmployeeMapper.mapToEmployeeDto(employes))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        
        Employess employess = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id: " + employeeId));
        
                employess.setFirstName(updatedEmployee.getFirstName());
                employess.setLastName(updatedEmployee.getLastName());
                employess.setEmail(updatedEmployee.getEmail());
                employess.setPhoneNumber(updatedEmployee.getPhoneNumber());

               Employess updatedEmployessObj = employeeRepository.save(employess);
        
                return EmployeeMapper.mapToEmployeeDto(updatedEmployessObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employess employess = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFound("Employee not found with id: " + employeeId));
    
             employeeRepository.deleteById(employeeId);
    }

}
