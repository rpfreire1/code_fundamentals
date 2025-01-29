package com.rpfreire.git.test.controller;

import com.rpfreire.git.test.entity.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {

    @PostMapping("/save")
    public Employee save(@RequestBody Employee employee){


        return employee;
    }
}
