package com.restapi.demo.controller;

import com.restapi.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{age}")
    public ResponseEntity<List> getEmployeesByAge(@PathVariable int age) {
        return new ResponseEntity<>(employeeService.getEmployeeByAge(age), HttpStatus.OK);
    }
    @GetMapping("/employees")
    public ResponseEntity<Map> getEmployeesGroupByAge() {
        return new ResponseEntity<>(employeeService.getEmployeesGroupByAge(), HttpStatus.OK);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        return new ResponseEntity("this is 404 response", HttpStatus.NOT_FOUND);
    }


}
