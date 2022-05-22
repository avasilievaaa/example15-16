package com.example15and16.employee.ServiceTest;

import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Exception.EmployeeBadException;
import com.example15and16.employee.Exception.EmployeeNotFoundException;
import com.example15and16.employee.Service.DepartmentServiceImpl;
import com.example15and16.employee.Service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    static Employee employee1 = new Employee("Иванова", "Юлия", 10, 100);
    static Employee employee2 = new Employee("Маст", "Николай", 11, 400);
    static Employee employee3 = new Employee("Игорь", "Винокуров", 10, 101);
    static Employee employee4 = new Employee("Анна", "Петрова", 21, 300);

    public static Map<String, Employee> employees = Map.of(
            "Иванова" + "Юлия", employee1,
            "Маст" + "Николай", employee2,
            "Игорь" + "Винокуров", employee3,
            "Анна" + "Петрова", employee4);

    public static Map<String, Employee> employees1 = Map.of(
            "Иванова" + "Юлия", employee1,
            "Игорь" + "Винокуров", employee3);

    public static List<Employee> lstFull = List.of(employee1, employee2, employee3, employee4);

    public static List <Employee> lst = List.of(employee1, employee3);

    @Test
    public void findMaxSalaryEmployeeInDepart() {
       when(employeeService.getEmployees()).thenReturn(lst);
        Employee getFindMaxSalaryEmployee = departmentService.getEmployeeWithMaxSalary(10);
        assertEquals(employee3, getFindMaxSalaryEmployee);
    }

    @Test
    public void findMinSalaryEmployeeInDepart() {
        when(employeeService.getEmployees()).thenReturn(lst);
        Employee getFindMinSalaryEmployee = departmentService.getEmployeeWithMinSalary(10);
        assertEquals(employee1, getFindMinSalaryEmployee);
    }

    @Test
    public void DepartNotExistsMaxSalaryEmployeeInDepart() {
        when(employeeService.getEmployees()).thenReturn(lst);
        assertThrows (EmployeeNotFoundException.class, () -> departmentService.getEmployeeWithMaxSalary(1));
    }

    @Test
    public void DepartNotExistsMinSalaryEmployeeInDepart() {
        when(employeeService.getEmployees()).thenReturn(lst);
        assertThrows (EmployeeNotFoundException.class, () -> departmentService.getEmployeeWithMinSalary(1));
    }
}