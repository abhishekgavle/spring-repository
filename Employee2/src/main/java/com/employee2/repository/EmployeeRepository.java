package com.employee2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<com.employee2.Entity.EmployeeEntity, Long>

{
    
}
