package com.example15and16.employee.Service;
import com.example15and16.employee.Employee.Employee;

import java.util.Collection;

public interface EmployeeService {
public Employee add (String firstName, String lastName);
public Employee remove (String firstName, String lastName);
public Employee find (String firstName, String lastName);
    Collection<Employee> getEmployees ();}