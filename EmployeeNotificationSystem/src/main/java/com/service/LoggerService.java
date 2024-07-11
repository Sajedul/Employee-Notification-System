package com.service;

import com.model.Employee;

public interface LoggerService {
    void logSuccess(Employee employee, long duration);
    void logFailure(Employee employee, String reason, long duration);
}
