import employee.EmployeeRepository;
import employee.EmployeeService;
import employee.PostcodesRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    private EmployeeService employeeService = new EmployeeService(new EmployeeRepository(),
            new PostcodesRepository("http://api.postcodes.io"));

    @Test
    public void countyAsExpectedForEmployeeId1() {
        assertEquals("Hertfordshire", employeeService.getCounty(1));
    }
}
