package be.pxl.microservices.services;
import be.pxl.microservices.domain.dto.EmployeeRequest;
import be.pxl.microservices.domain.dto.EmployeeResponse;
import java.util.List;

public interface IEmployeeService {
    List<EmployeeResponse> getAllEmployees();

    void addEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse getEmployeesByDepartmentId(Long departmentId);

    EmployeeResponse getEmployeesByOrganizationId(Long organizationId);
}
