package com.example15and16.employee.Service;
import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Exception.EmployeeBadException;
import com.example15and16.employee.Exception.EmployeeFullArrayException;
import com.example15and16.employee.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    Employee[] employees = {
        new Employee("Николай", "Семёнов"),
        new Employee("Роман", "Карлов"),
        new Employee("Вероника", "Павлова")};
private int size;
private boolean employeeCompare (String firstName, String lastName, Employee employee) {
        boolean compare = employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName);
        return compare;}
@Override
public Employee addEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        if (size == employees.length) {throw new EmployeeFullArrayException();}
        int index = indexOf(newEmployee);
        if (index != -1) {throw new EmployeeBadException();}
        employees[size++] = newEmployee;
        return newEmployee;}
@Override
public Employee removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.length; i++) {
        if (employees[i] != null && employeeCompare(firstName, lastName, employees[i])) {
        employees[i] = null;
        size--;
        return new Employee (firstName,lastName);}}
        throw new EmployeeNotFoundException();}
@Override
public Employee findEmployee(String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        int index = indexOf(newEmployee);
        if (index != -1) {return employees[index];}
        throw new EmployeeNotFoundException();}
@Override
public int indexOf(Employee employee) {
        for (int i = 0; i < size; i++) {
        if (employees[i].equals(employee)) {return i;}
        }return -1;}}