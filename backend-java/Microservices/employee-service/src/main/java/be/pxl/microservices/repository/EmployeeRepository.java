package be.pxl.microservices.repository;

import be.pxl.microservices.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByDepartmentId(Long employeeId);
    Employee findByOrganizationId(Long organizationId);
}
