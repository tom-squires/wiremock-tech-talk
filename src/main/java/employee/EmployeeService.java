package employee;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CountryRepository countryRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           CountryRepository countryRepository) {
        this.employeeRepository = employeeRepository;
        this.countryRepository = countryRepository;
    }

    public String getCountry(Integer employeeId) {
        Employee employee = employeeRepository.getEmployee(employeeId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return countryRepository.getCountry(employee.getPostCode())
                .orElseThrow(() -> new RuntimeException("Postcode not found"));
    }
}
