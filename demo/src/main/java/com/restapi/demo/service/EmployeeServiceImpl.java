package com.restapi.demo.service;

import com.restapi.demo.domain.EmployeeDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final Log logger = LogFactory.getLog(EmployeeServiceImpl.class);
    private final RestTemplate restTemplate;
    private final List<EmployeeDTO> employeeList;
    public EmployeeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        String resourceUrl = "https://dummy.restapiexample.com/api/v1/employees\n";
        ResponseEntity<List> response = restTemplate.getForEntity(resourceUrl, List.class);
        employeeList = response.getBody();
    }


    @Override
    public List<EmployeeDTO> getEmployeeByAge(int age) {
        List<EmployeeDTO> res = new ArrayList<>();
        for(EmployeeDTO employee : employeeList) {
            if (employee.getAge() >= age)
            res.add(employee);
        }
        return res;
    }

    @Override
    public Map<Integer, List<EmployeeDTO>> getEmployeesGroupByAge() {
       Map<Integer, List<EmployeeDTO>> res = new HashMap<>();
        for(EmployeeDTO employee : employeeList) {
            res.put(employee.getAge(), (List<EmployeeDTO>) employee);
        }
       return res;
    }
}