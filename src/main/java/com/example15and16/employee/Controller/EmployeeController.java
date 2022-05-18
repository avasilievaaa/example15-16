package com.example15and16.employee.Controller;
import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String Employee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam int salary) {
        Employee result = employeeService.add(firstName, lastName, departmentId, salary);
        return generateMassage(result, "успешно создан");
    }

    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        Employee result = employeeService.remove(firstName, lastName);
        return generateMassage(result, "удален");
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.find(firstName, lastName);
    }

    private String generateMassage(Employee employee, String status) {
        return String.format("Сотрудник %s %s %s ",
                employee.getFirstName(),
                employee.getLastName(),
                status);
    }
}