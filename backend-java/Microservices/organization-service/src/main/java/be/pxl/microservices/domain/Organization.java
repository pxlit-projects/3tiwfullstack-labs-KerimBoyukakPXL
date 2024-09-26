package be.pxl.microservices.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "organization")
@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    @Id
    private Long id;
    private String name;
    private String address;
    @Transient
    private List<Employee> employees;
    @Transient
    private List<Department> departments;
}
