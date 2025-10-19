package com.server.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.store.entity.Employess;

public interface EmployeeRepository extends JpaRepository<Employess, Long> {

}
