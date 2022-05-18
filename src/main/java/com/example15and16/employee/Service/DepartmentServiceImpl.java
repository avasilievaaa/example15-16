package com.example15and16.employee.Service;

import com.example15and16.employee.Employee.Employee;

import com.example15and16.employee.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId(departmentId))
                .max(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @Override
    public Employee getEmployeeWithMinSalary(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId(departmentId))
                .min(Comparator.comparing(employee -> employee.getSalary()))
                .orElseThrow(() -> new EmployeeNotFoundException());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartment(int departmentId) {
        return (Map<Integer, List<Employee>>) employeeService.getEmployees().stream()
                .filter(employee -> employee.getDepartmentId(departmentId))
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
