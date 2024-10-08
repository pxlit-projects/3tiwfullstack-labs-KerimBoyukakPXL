package be.pxl.microservices.services;

import be.pxl.microservices.client.EmployeeClient;
import be.pxl.microservices.domain.Department;
import be.pxl.microservices.domain.dto.DepartmentRequest;
import be.pxl.microservices.domain.dto.DepartmentResponse;
import be.pxl.microservices.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService implements IDepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @Override
    public List<DepartmentResponse> getAllEmployees() {
        List <Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(department -> mapToDepartmentResponse(department)).toList();
    }

    @Override
    public void addDepartment(DepartmentRequest departmentRequest) {
        Department department = Department.builder()
                .name(departmentRequest.getName())
                .position(departmentRequest.getPosition())
                .employees(departmentRequest.getEmployees())
                .organizationId(departmentRequest.getOrganizationId())
                .build();
        departmentRepository.save(department);

    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow();
        //employeeClient.findEmployeeByDepartment(id);
        return mapToDepartmentResponse(department);
    }

    @Override
    public List<DepartmentResponse> getDepartmentsByOrganizationId(Long organizationId) {
        List <Department> departments = departmentRepository.findByOrganizationId(organizationId).stream().toList();
        return departments.stream()
                .map(department -> mapToDepartmentResponseWithoutEmployees(department)).toList();
    }

    @Override
    public List<DepartmentResponse> getDepartmentsByOrganizationIdWithEmployees(Long organizationId) {
        List <Department> departments = departmentRepository.findByOrganizationId(organizationId).stream().toList();
        return departments.stream()
                .map(department -> mapToDepartmentResponse(department)).toList();
    }

    private DepartmentResponse mapToDepartmentResponse(Department department) {
        return DepartmentResponse.builder()
                .name(department.getName())
                .position(department.getPosition())
                .employees(department.getEmployees())
                .organizationId(department.getOrganizationId())
                .build();
    }
    private DepartmentResponse mapToDepartmentResponseWithoutEmployees(Department department) {
        return DepartmentResponse.builder()
                .name(department.getName())
                .position(department.getPosition())
                .organizationId(department.getOrganizationId())
                .build();
    }
}
