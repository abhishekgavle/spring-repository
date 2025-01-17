
package com.employee2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private String name;
    private long mobile;
    private String email;
    private double salary;  
    private int age;
    private char gender;
    private String department;
    private String address;
}
