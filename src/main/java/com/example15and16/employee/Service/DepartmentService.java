package com.example15and16.employee.Service;

import com.example15and16.employee.Employee.Employee;

import java.util.List;
import java.util.Map;


public interface DepartmentService {
    Employee getEmployeeWithMaxSalary(int departmentId);

    Employee getEmployeeWithMinSalary(int departmentId);

    Map<Integer, List<Employee>> getAllEmployees();

    Map<Integer, List<Employee>> getEmployeesByDepartment(int departmentId);
}
