package com.example15and16.employee.Employee;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int departmentId;
    private int salary;

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int department) {
        this.departmentId = department;
    }

    public boolean getDepartmentId(int department) {
        return this.departmentId == department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return departmentId == employee.departmentId && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "firstName: " + this.firstName + ", lastName: " + this.lastName + ", departmentId: " + this.departmentId + ", salary: " + this.salary;
    }
}