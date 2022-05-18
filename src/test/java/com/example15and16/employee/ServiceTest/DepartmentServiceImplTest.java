package com.example15and16.employee.ServiceTest;

import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Exception.EmployeeBadException;
import com.example15and16.employee.Service.DepartmentServiceImpl;
import com.example15and16.employee.Service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceImplTest {
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

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

    public static List<Employee> lst = List.of(employee1, employee3);

    @Test
    public void findMaxSalaryEmployeeInDepart() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        Employee getFindMaxSalaryEmployee = out.getEmployeeWithMaxSalary(10);
        assertEquals(employee3, getFindMaxSalaryEmployee);
    }

    @Test
    public void findMinSalaryEmployeeInDepart() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        Employee getFindMinSalaryEmployee = out.getEmployeeWithMinSalary(10);
        assertEquals(employee1, getFindMinSalaryEmployee);
    }

    @Test
    public void DepartNotExists() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        assertThrows(EmployeeBadException.class, () -> out.getEmployeesByDepartment(1));
    }

    @Test
    void findAll() {
        when(employeeServiceMock.showEmployee()).thenReturn(employees);
        List<Employee> allEmployeesInDepart = (List<Employee>) out.getEmployeesByDepartment(10);
        assertEquals(lst, allEmployeesInDepart);
    }
}