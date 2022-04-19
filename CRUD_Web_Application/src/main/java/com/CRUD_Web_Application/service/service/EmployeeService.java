package com.CRUD_Web_Application.service.service;

import com.CRUD_Web_Application.model.Employee;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployee(long id);
}
