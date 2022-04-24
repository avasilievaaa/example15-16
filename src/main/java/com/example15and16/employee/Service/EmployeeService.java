package com.example15and16.employee.Service;

import com.example15and16.employee.Employee.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int departmentId, int salary);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> getEmployees();
}