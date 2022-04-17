package com.example15and16.employee.Service;
import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Exception.EmployeeFullArrayException;
import com.example15and16.employee.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Service
public class EmployeeServiceImpl implements EmployeeService {
private final Set<Employee> employees;
public EmployeeServiceImpl () {employees = new HashSet<>();}
@Override
public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {throw new EmployeeFullArrayException();}
        employees.add(employee);
        return employee;}
@Override
public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {throw new EmployeeNotFoundException();}
        employees.remove(employee);
        return employee;}
@Override
public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {throw new EmployeeNotFoundException();}
        return employee;}
@Override
public Collection<Employee> getEmployees () {return Set.copyOf(employees);}}