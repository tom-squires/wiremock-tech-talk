import employee.EmployeeRepository;
import employee.EmployeeService;
import employee.CountryRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    private EmployeeService employeeService = new EmployeeService(new EmployeeRepository(),
            new CountryRepository("http://api.postcodes.io"));

    @Test
    public void countryAsExpectedForEmployeeId() {
        assertEquals("England", employeeService.getCountry(1));
        assertEquals("Wales", employeeService.getCountry(2));
        assertEquals("Scotland", employeeService.getCountry(3));
    }
}
