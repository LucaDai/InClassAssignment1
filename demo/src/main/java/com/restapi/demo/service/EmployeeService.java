package com.restapi.demo.service;

import com.restapi.demo.domain.EmployeeDTO;

import java.util.List;
import java.util.Map;

public interface EmployeeService {



    List<EmployeeDTO> getEmployeeByAge(int age);



    Map<Integer, List<EmployeeDTO>> getEmployeesGroupByAge();
}
