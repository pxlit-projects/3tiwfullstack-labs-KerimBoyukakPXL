package be.pxl.microservices.controller;

import be.pxl.microservices.domain.dto.EmployeeRequest;
import be.pxl.microservices.services.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor    // lombok injecteert zelf de services in de constructor
public class EmployeeController {
    private final IEmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployee(@RequestBody EmployeeRequest employeeRequest) {
        employeeService.addEmployee(employeeRequest);
    }

    @GetMapping
    public ResponseEntity getEmployees() {
        return new ResponseEntity(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
        return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity getEmployeesByDepartmentId(@PathVariable Long departmentId) {
        return new ResponseEntity(employeeService.getEmployeesByDepartmentId(departmentId), HttpStatus.OK);
    }

    @GetMapping("/organization/{organizationId}")
    public ResponseEntity getEmployeesByOrganizationId(@PathVariable Long organizationId) {
        return new ResponseEntity(employeeService.getEmployeesByOrganizationId(organizationId), HttpStatus.OK);
    }


}
