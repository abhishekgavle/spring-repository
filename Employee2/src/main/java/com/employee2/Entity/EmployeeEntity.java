package com.employee2.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Assuming the ID is a Long
    private String name;
    private long mobile;
    private String email;
    private double salary;  // Double to match the model
    private int age;
    private char gender;
    private String department;
    private String address;
    private double pf; // Provident fund
    private double hra; // House rent allowance
    private double da;  // Dearness allowance
    private double sa;  // Special allowance
}
