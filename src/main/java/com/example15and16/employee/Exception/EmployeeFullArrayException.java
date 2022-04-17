package com.example15and16.employee.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeFullArrayException extends RuntimeException {
private static final String DEFAILT_MESSAGE = "Нет места для добавления сотрудника";
public EmployeeFullArrayException () {super(DEFAILT_MESSAGE);}}