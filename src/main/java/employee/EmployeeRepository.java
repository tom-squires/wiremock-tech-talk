package employee;

import java.util.Map;
import java.util.Optional;

public class EmployeeRepository {
    // This is a stub
    private final Map<Integer, Employee> employees = Map.of(
            1, new Employee(1, "Tom Squires", "WD33AQ"),
            2, new Employee(2, "Matt Gray", "ST104DB"),
            3, new Employee(3, "Eugene Melnik", "HA90AA")
    );

    Optional<Employee> getEmployee(Integer employeeId) {
        return Optional.ofNullable(employees.get(employeeId));
    }
}
