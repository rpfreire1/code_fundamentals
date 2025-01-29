package com.rpfreire.git.test.controller;

import com.rpfreire.git.test.entity.Employee;
import com.rpfreire.git.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){

        return employeeService.saveEmployee(employee);
    }
    @GetMapping("/list")
    public List<Employee> list(){
        return employeeService.getEmployees();
    }
    @PostMapping("/get")
    public Employee get(@RequestBody String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id){
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }



}
