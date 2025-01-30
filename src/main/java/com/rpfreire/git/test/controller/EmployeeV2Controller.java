package com.rpfreire.git.test.controller;

import com.rpfreire.git.test.model.Employee;
import com.rpfreire.git.test.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {
    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);

    }
}
