package be.pxl.microservices.services;

import be.pxl.microservices.client.NotificationClient;
import be.pxl.microservices.domain.Employee;
import be.pxl.microservices.domain.dto.EmployeeRequest;
import be.pxl.microservices.domain.dto.EmployeeResponse;
import be.pxl.microservices.domain.dto.NotificationRequest;
import be.pxl.microservices.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements IEmployeeService {
    private final EmployeeRepository employeeRepository;
    private final NotificationClient notificationClient;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream()
                .map(employee -> mapToEmployeeResponse(employee)).toList();
    }

    @Override
    public void addEmployee(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .name(employeeRequest.getName())
                .age(employeeRequest.getAge())
                .position(employeeRequest.getPosition())
                .build();
        employeeRepository.save(employee);

        NotificationRequest notificationRequest = NotificationRequest.builder()
                .message("Employee " + employee.getName() + " created")
                .sender("Kerim")
                .build();
        notificationClient.sendNotification(notificationRequest);
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        return mapToEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse getEmployeesByDepartmentId(Long departmentId) {
        Employee employee = employeeRepository.findByDepartmentId(departmentId);
        return mapToEmployeeResponse(employee);
    }

    @Override
    public EmployeeResponse getEmployeesByOrganizationId(Long organizationId) {
        Employee employee = employeeRepository.findByOrganizationId(organizationId);
        return mapToEmployeeResponse(employee);
    }

    private EmployeeResponse mapToEmployeeResponse(Employee employee) {
        return EmployeeResponse.builder()
                .name(employee.getName())
                .age(employee.getAge())
                .position(employee.getPosition())
                .build();
    }
}
