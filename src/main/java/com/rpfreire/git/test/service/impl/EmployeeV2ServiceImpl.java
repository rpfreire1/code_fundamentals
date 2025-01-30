package com.rpfreire.git.test.service.impl;

import com.rpfreire.git.test.entity.EmployeeEntity;
import com.rpfreire.git.test.error.EmployeeNotFoundException;
import com.rpfreire.git.test.model.Employee;
import com.rpfreire.git.test.repository.EmployeeRepository;
import com.rpfreire.git.test.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        if (employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);

        employeeRepository.save(employeeEntity);
        return employee;
    }

    public List<Employee> getEmployees() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        if (employees.isEmpty()){
            throw  new RuntimeException("No employees found");
        }
        List<Employee> employeeList = new ArrayList<>();
        employeeList=employees.stream().map(employeeEntity -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            return employee;
        }).collect(Collectors.toList());

        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String employeeId) {
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).orElseThrow(()->new EmployeeNotFoundException("Employee with Id "+employeeId+"not found"));
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;

    }

    @Override
    public String deleteEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with Id "+id+"not found"));
        employeeRepository.delete(employeeEntity);
        return "Employee with Id "+id+" deleted";

    }


}
