package be.pxl.microservices.services;
import be.pxl.microservices.domain.dto.OrganizationResponse;

public interface IOrganizationService {
    OrganizationResponse getOrganizationById(Long id);

    OrganizationResponse getOrganizationByIdWithDepartments(Long id);

    OrganizationResponse getOrganizationByIdWithEmployees(Long id);

    OrganizationResponse getOrganizationByIdWithDepartmentsAndEmployees(Long id);
}
