package com.example15and16.employee.Service;

import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Exception.EmployeeFullArrayException;
import com.example15and16.employee.Exception.EmployeeNotFoundException;
import com.example15and16.employee.Exception.EmployeeBadException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.tomcat.util.IntrospectionUtils.capitalize;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int departmentId, int salary) {
        infoCheck(capitalize(firstName), capitalize(lastName));
        Employee employee = new Employee(capitalize(firstName), capitalize(lastName), departmentId, salary);
        if (employees.containsKey(firstName + lastName)) {
            throw new EmployeeFullArrayException();
        }
        employees.put(firstName + lastName, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        infoCheck(capitalize(firstName), capitalize(lastName));
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(firstName + lastName);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        infoCheck(capitalize(firstName), capitalize(lastName));
        if (!employees.containsKey(firstName + lastName)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(firstName + lastName);
    }

    @Override
    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }

    private Employee infoCheck(String firstName, String lastName) {
        if (!StringUtils.isAlpha(firstName) || !StringUtils.isAlpha(lastName)) {
            throw new EmployeeBadException();
        }
        return employees.get(firstName + lastName);
    }
}