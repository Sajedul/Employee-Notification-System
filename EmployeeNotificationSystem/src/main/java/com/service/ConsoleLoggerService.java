package com.service;

import com.model.Employee;
import com.service.LoggerService;

public class ConsoleLoggerService implements LoggerService {
    @Override
    public void logSuccess(Employee employee, long duration) {
        System.out.println("SUCCESS: Email sent to " + employee.getEmail() +
                " in " + duration + " ms.");
    }

    @Override
    public void logFailure(Employee employee, String reason, long duration) {
        System.out.println("FAILURE: Email to " + employee.getEmail() +
                " failed due to " + reason +
                " in " + duration + " ms.");
    }
}
