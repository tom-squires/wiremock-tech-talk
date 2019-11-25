package employee;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final PostcodesRepository postcodesRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           PostcodesRepository postcodesRepository) {
        this.employeeRepository = employeeRepository;
        this.postcodesRepository = postcodesRepository;
    }

    public String getCounty(Integer employeeId) {
        Employee employee = employeeRepository.getEmployee(employeeId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return postcodesRepository.getCounty(employee.getPostCode())
                .orElseThrow(() -> new RuntimeException("Postcode not found"));
    }
}
