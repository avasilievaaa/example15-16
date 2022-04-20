package com.example15and16.employee.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeBadException extends RuntimeException {
    private static final String DEFAILT_MESSAGE = "Добавляемый сотрудник уже имеется в массиве";
    public EmployeeBadException() {
        super(DEFAILT_MESSAGE);
    }
}