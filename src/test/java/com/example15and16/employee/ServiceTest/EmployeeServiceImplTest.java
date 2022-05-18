package com.example15and16.employee.ServiceTest;

import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Exception.EmployeeBadException;
import com.example15and16.employee.Service.EmployeeServiceImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EmployeeServiceImplTest {
    private static final EmployeeServiceImpl out = new EmployeeServiceImpl();

    static Employee employee1 = new Employee("Иванова", "Юлия", 10, 100);
    static Employee employee2 = new Employee("Петрова", "Анна", 11, 200);


    public static Stream<Arguments> provideParametersForTestsDeleteMotExistsEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванова", "Юлия", 10, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsDeleteMotExistsEmployee")
    public void checkMethodsDeleteMotExistsEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.add(firstName, lastName, department, salary));
        assertThrows(EmployeeBadException.class, () -> out.remove(firstName + "1", lastName));
        assertThrows(EmployeeBadException.class, () -> out.remove(firstName, lastName + "1"));

    }

    public static Stream<Arguments> provideParametersForTestsDeleteEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванова", "Юлия", 10, 100),
                Arguments.of(employee2, "Петрова", "Анна", 11, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsRemoveEmployee")
    public void checkMethodsRemoveEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.add(firstName, lastName, department, salary));
        assertEquals(empl, out.remove(firstName, lastName));
    }


    public static Stream<Arguments> provideParametersForTestsFindEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванова", "Юлия", 10, 100),
                Arguments.of(employee2, "Петрова", "Анна", 11, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsFindEmployee")
    public void checkMethodsFindEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.add(firstName, lastName, department, salary));
        assertEquals(empl, out.find(firstName, lastName));
    }


    public static Stream<Arguments> provideParametersForTestsAddEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванова", "Юлия", 10, 100),
                Arguments.of(employee2, "Петрова", "Анна", 11, 200)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsAddEmployee")
    public void checkMethodsAddEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.add(firstName, lastName, department, salary));
    }


    public static Stream<Arguments> provideParametersForTestsAddExistsAndWithErrorsEmployee() {
        return Stream.of(
                Arguments.of(employee1, "Иванова", "Юлия", 10, 100)
        );
    }

    @ParameterizedTest
    @MethodSource("provideParametersForTestsAddExistsAndWithErrorsEmployee")
    public void checkMethodsAddExistsEmployee(Employee empl, String firstName, String lastName, int department, int salary) {
        assertEquals(empl, out.add(firstName, lastName, department, salary));
        assertThrows(EmployeeBadException.class, () -> out.add("", lastName, department, salary));
        assertThrows(EmployeeBadException.class, () -> out.add(firstName, "", department, salary));
    }
}