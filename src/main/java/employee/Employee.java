package employee;

import java.util.Objects;

public class Employee {
    private final Integer employeeId;
    private final String fullName;
    private final String postCode;

    Employee(Integer employeeId, String fullName, String postCode) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.postCode = postCode;
    }

    String getPostCode() {
        return postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeId, employee.employeeId) &&
                Objects.equals(fullName, employee.fullName) &&
                Objects.equals(postCode, employee.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, fullName, postCode);
    }
}
