package com.rpfreire.git.test.service.impl;

import com.rpfreire.git.test.entity.Employee;
import com.rpfreire.git.test.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees=new ArrayList<>();
    public Employee saveEmployee(Employee employee) {
        if (employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    public List<Employee> getEmployees() {
        if (employees.isEmpty()){
            throw  new RuntimeException("No employees found");
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        return employees.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst().get();
    }

}
