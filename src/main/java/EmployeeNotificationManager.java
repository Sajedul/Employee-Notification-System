import java.io.IOException;
import java.util.List;

public class EmployeeNotificationManager {
    private FileReaderService fileReaderService;
    private EmailService emailService;
    private LoggerService loggerService;

    public EmployeeNotificationManager(FileReaderService fileReaderService, EmailService emailService, LoggerService loggerService) {
        this.fileReaderService = fileReaderService;
        this.emailService = emailService;
        this.loggerService = loggerService;
    }

    public void notifyEmployees() {
        try {
            List<Employee> employees = fileReaderService.readEmployees();
            for (Employee employee : employees) {
                long startTime = System.currentTimeMillis();
                try {
                    emailService.sendEmail(employee);
                    long duration = System.currentTimeMillis() - startTime;
                    loggerService.logSuccess(employee, duration);
                } catch (Exception e) {
                    long duration = System.currentTimeMillis() - startTime;
                    loggerService.logFailure(employee, e.getMessage(), duration);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
