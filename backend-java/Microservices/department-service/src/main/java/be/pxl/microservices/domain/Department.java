package be.pxl.microservices.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "department")
@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    private Long id;
    private Long organizationId;
    private String name;
    
    @Transient  // OneToMany is not possible with different databases in each service
    private List<Employee> employees;
    private String position;

}
