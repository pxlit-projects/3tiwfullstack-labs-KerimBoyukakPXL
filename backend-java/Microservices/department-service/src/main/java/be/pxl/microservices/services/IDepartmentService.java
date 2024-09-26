package be.pxl.microservices.services;



import be.pxl.microservices.domain.dto.DepartmentRequest;
import be.pxl.microservices.domain.dto.DepartmentResponse;

import java.util.List;

public  interface IDepartmentService {
    List<DepartmentResponse> getAllEmployees();

    void addDepartment(DepartmentRequest departmentRequest);

    DepartmentResponse getDepartmentById(Long id);
    
    List<DepartmentResponse> getDepartmentsByOrganizationId(Long organizationId);

    List<DepartmentResponse> getDepartmentsByOrganizationIdWithEmployees(Long organizationId);
}
