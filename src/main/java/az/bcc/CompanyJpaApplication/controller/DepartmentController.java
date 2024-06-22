package az.bcc.CompanyJpaApplication.controller;

import az.bcc.CompanyJpaApplication.entity.Department;
import az.bcc.CompanyJpaApplication.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department databaseDepartment = departmentService.addDepartment(department);
        return ResponseEntity.status(201).body(databaseDepartment);
    }

    @PutMapping("/updateDepartment")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
        Department databaseDepartment = departmentService.updateDepartment(department);
        return ResponseEntity.ok(databaseDepartment);
    }

    @GetMapping("/getAllDepartment")
    public ResponseEntity<List<Department>> getAllDepartment() {
        List<Department> departments = departmentService.getAllDepartment();
        return ResponseEntity.ok(departments);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.ok("Delete department");
    }
}
