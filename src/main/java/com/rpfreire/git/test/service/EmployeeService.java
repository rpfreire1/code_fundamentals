package com.rpfreire.git.test.service;

import com.rpfreire.git.test.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);
    List<Employee> getEmployees();
    Employee getEmployeeById(String employeeId);

    String deleteEmployeeById(String id);
}
