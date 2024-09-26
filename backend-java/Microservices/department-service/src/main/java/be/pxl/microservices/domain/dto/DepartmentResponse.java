package be.pxl.microservices.domain.dto;

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
public class DepartmentResponse {
    private Long organizationId;
    private String name;
    private List<Employee> employees;
    private String position;
}
