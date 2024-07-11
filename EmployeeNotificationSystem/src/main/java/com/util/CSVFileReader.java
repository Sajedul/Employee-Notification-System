package com.util;

import com.model.Employee;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.service.FileReaderService;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CSVFileReader implements FileReaderService {
    private String filePath;

    public CSVFileReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Employee> readEmployees() throws IOException {
        List<Employee> employees = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] nextLine;
            boolean isFirstRow = true; // To track the header row
            while ((nextLine = reader.readNext()) != null) //This method reads the next line from the CSV file and returns it as an array of Strings
            {
                if (isFirstRow) {
                    isFirstRow = false; // Skip the header row
                    continue;
                }
                    // Ensure that each line has the expected number of fields
                if (nextLine.length == 5) {
                        Employee employee = new Employee(
                                nextLine[0], // name
                                Integer.parseInt(nextLine[1]), // id
                                nextLine[2], // designation
                                nextLine[3], // month
                                nextLine[4]  // email
                        );
                        employees.add(employee);
                    }else {
                    System.err.println("Invalid line: " + String.join(",", nextLine));
                }
                }
            } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return employees;
        }
    }
