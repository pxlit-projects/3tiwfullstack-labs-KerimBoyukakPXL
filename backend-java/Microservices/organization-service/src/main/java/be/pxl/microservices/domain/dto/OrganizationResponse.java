package be.pxl.microservices.domain.dto;

import be.pxl.microservices.domain.Department;
import be.pxl.microservices.domain.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationResponse {
    private String name;
    private String address;
    private List<Employee> employees;
    private List<Department> departments;
}
