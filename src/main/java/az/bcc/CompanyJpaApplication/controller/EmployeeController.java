package az.bcc.CompanyJpaApplication.controller;

import az.bcc.CompanyJpaApplication.entity.Employee;
import az.bcc.CompanyJpaApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee databaseEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.status(201).body(databaseEmployee);
    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee databaseEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(databaseEmployee);
    }

    @GetMapping("/getAllEmployee")
    public ResponseEntity<List<Employee>> gelAllEmployee() {
        List<Employee> employees = employeeService.getAllEmployee();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok("delete employee");
    }
}
