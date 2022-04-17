package com.example15and16.employee.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
private static final String DEFAILT_MESSAGE = "Сотрудник не найден";
public EmployeeNotFoundException () {super(DEFAILT_MESSAGE);}}