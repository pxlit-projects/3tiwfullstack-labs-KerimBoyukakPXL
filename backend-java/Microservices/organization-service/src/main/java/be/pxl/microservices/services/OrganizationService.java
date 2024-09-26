package be.pxl.microservices.services;

import be.pxl.microservices.domain.Department;
import be.pxl.microservices.domain.Organization;
import be.pxl.microservices.domain.dto.DepartmentResponse;
import be.pxl.microservices.domain.dto.OrganizationResponse;
import be.pxl.microservices.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationService implements IOrganizationService {
    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationResponse getOrganizationById(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow();
        return mapToOrganizationResponseWithoutEmployeesAndDepartments(organization);
    }

    @Override
    public OrganizationResponse getOrganizationByIdWithDepartments(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow();
        return mapToOrganizationResponseWithoutEmployees(organization);
    }

    @Override
    public OrganizationResponse getOrganizationByIdWithEmployees(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow();
        return mapToOrganizationResponseWithoutDepartments(organization);
    }

    @Override
    public OrganizationResponse getOrganizationByIdWithDepartmentsAndEmployees(Long id) {
        Organization organization = organizationRepository.findById(id).orElseThrow();
        return mapToOrganizationResponse(organization);
    }

    private OrganizationResponse mapToOrganizationResponse(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .employees(organization.getEmployees())
                .departments(organization.getDepartments())
                .build();
    }
    private OrganizationResponse mapToOrganizationResponseWithoutEmployees(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .departments(organization.getDepartments())
                .build();
    }
    private OrganizationResponse mapToOrganizationResponseWithoutDepartments(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .employees(organization.getEmployees())
                .build();
    }
    private OrganizationResponse mapToOrganizationResponseWithoutEmployeesAndDepartments(Organization organization) {
        return OrganizationResponse.builder()
                .name(organization.getName())
                .address(organization.getAddress())
                .employees(organization.getEmployees())
                .departments(organization.getDepartments())
                .build();
    }
}
