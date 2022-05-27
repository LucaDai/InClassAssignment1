package com.restapi.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private String employee_name;
    private String id;
    private int employee_age;
    private Data profile_image;

    public EmployeeDTO(Employee employee) {
        this.employee_name = employee.employee_name;
        this.id = employee.id;
        this.employee_age = employee.employee_age;
        this.profile_image = (Data) employee.profile_image;
    }
    public int getAge() {
        return employee_age;
    }
}
