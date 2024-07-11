import com.service.*;
import com.util.CSVFileReader;
import com.util.DatabaseReader;
import com.controller.EmployeeNotificationManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FileReaderService fileReaderService= null;

        System.out.println("Select the input source:");
        System.out.println("1. CSV File");
        System.out.println("2. Database");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter the CSV file path(e.g., src//EmployeeInfo.csv): ");
                String csvFilePath = scanner.nextLine();
                fileReaderService = new CSVFileReader(csvFilePath);
                break;
            case 2:
                System.out.print("Enter the database URL (e.g., jdbc:mysql://localhost:3306/schooldb): ");
                String dbUrl = scanner.nextLine();
                System.out.print("Enter the database user(e.g.,root): ");
                String dbUser = scanner.nextLine();
                System.out.print("Enter the database password(mysql): ");
                String dbPassword = scanner.nextLine();
                fileReaderService = new DatabaseReader(dbUrl, dbUser, dbPassword);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                System.exit(0);
        }
        if (fileReaderService!= null) {
            EmailService emailService = new EmailTrapService(); //  email service implementation
            LoggerService loggerService = new ConsoleLoggerService(); //  logger service implementation
            EmployeeNotificationManager manager = new EmployeeNotificationManager(fileReaderService, emailService, loggerService);
            manager.notifyEmployees();
        }

    }
}

/*  String csvFilePath = "src//EmployeeInfo.csv";
        String dbUrl = "jdbc:mysql://localhost:3306/schooldb";
        String dbUser = "root";
        String dbPassword = "mysql";

        FileReaderService fileReaderService = new CSVFileReader(csvFilePath); // or database input;
        //Or
       // FileReaderService fileReaderService = new DatabaseReader(dbUrl, dbUser, dbPassword);

         EmailService emailService = new EmailTrapService();
        LoggerService loggerService = new ConsoleLoggerService();
        EmployeeNotificationManager obj = new EmployeeNotificationManager(
                fileReaderService, emailService, loggerService
        );

        obj.notifyEmployees(); // or db file

        */