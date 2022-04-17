package com.example15and16.employee.Service;
import com.example15and16.employee.Employee.Employee;
public interface EmployeeService {
public Employee addEmployee (String firstName, String lastName);
public Employee removeEmployee (String firstName, String lastName);
public Employee findEmployee (String firstName, String lastName);
public int indexOf(Employee employee);}