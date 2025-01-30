package com.rpfreire.git.test.repository;

import com.rpfreire.git.test.entity.EmployeeEntity;
import com.rpfreire.git.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {

}
