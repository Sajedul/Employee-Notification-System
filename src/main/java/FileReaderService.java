import java.io.IOException;
import java.util.List;

public interface FileReaderService {
    List<Employee> readEmployees() throws IOException;
}
