package com.example15and16.employee.Controller;

import com.example15and16.employee.Employee.Employee;
import com.example15and16.employee.Service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    Employee getEmployeeWithMaxSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }

    @GetMapping(path = "/min-salary")
    Employee getEmployeeWithMinSalary(@RequestParam("departmentId") int departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(path = "/all")
    Map<Integer, List<Employee>> getEmployeesByDepartment(@RequestParam("departmentId") int departmentId) {
        return departmentService.getEmployeesByDepartment(departmentId);
    }

    @GetMapping(path = "/all", params = {"departmentId"})
    Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}