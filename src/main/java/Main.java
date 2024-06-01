public class Main {
    public static void main(String[] args) {
        FileReaderService fileReaderService = new CSVFileReader(); // or new ExcelFileReader();
        EmailService emailService = new EmailTrapService();
        LoggerService loggerService = new ConsoleLoggerService();

        EmployeeNotificationManager obj = new EmployeeNotificationManager(
                fileReaderService, emailService, loggerService
        );

        obj.notifyEmployees("src//EmployeeInfo.csv"); // or .xlsx for Excel files
    }
}