package com.service;

import com.model.Employee;

public interface EmailService {
    void sendEmail(Employee employee) throws Exception;
}
