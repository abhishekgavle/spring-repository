package com.employee2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee2.Entity.EmployeeEntity;
import com.employee2.model.EmployeeModel;
import com.employee2.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    // Save employee details
    public void saveEmployeeDetails(EmployeeModel EmployeeModel) {
        if (EmployeeModel == null) {
            throw new IllegalArgumentException("EmployeeModel cannot be null");
        }

        double pf = EmployeeModel.getSalary() * 0.12;
        double hra = EmployeeModel.getSalary() * 0.20;
        double da = EmployeeModel.getSalary() * 0.10;
        double sa = EmployeeModel.getSalary() * 0.08;

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(EmployeeModel.getName());
        employeeEntity.setEmail(EmployeeModel.getEmail());
        employeeEntity.setMobile(EmployeeModel.getMobile());
        employeeEntity.setAge(EmployeeModel.getAge());
        employeeEntity.setGender(EmployeeModel.getGender());
        employeeEntity.setDepartment(EmployeeModel.getDepartment());
        employeeEntity.setSalary(EmployeeModel.getSalary());
        employeeEntity.setAddress(EmployeeModel.getAddress());

        employeeEntity.setPf(pf);
        employeeEntity.setHra(hra);
        employeeEntity.setDa(da);
        employeeEntity.setSa(sa);

        employeeRepository.save(employeeEntity);
    }

    // Get all employees
    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Search employee by ID
    public Optional<EmployeeEntity> searchById(Long id) {
        return employeeRepository.findById(id);
    }

    // Delete employee by ID
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }
}
