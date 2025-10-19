package com.server.store.mapper;

import com.server.store.dto.EmployeeDto;
import com.server.store.entity.Employess;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Employess employess){
        return new EmployeeDto(
            employess.getId(),
            employess.getFirstName(),
            employess.getLastName(),
            employess.getEmail(),
            employess.getPhoneNumber()
        );
    }

    public static Employess mapToEmployee(EmployeeDto employeeDto){
        return new Employess(
            employeeDto.getId(),
            employeeDto.getFirstName(),
            employeeDto.getLastName(),
            employeeDto.getEmail(),
            employeeDto.getPhoneNumber()
        );
    }
}
