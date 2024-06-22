package az.bcc.CompanyJpaApplication.controller;

import az.bcc.CompanyJpaApplication.entity.Company;
import az.bcc.CompanyJpaApplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/addCompany")
    public ResponseEntity<Company> addCompany(@RequestBody Company company) {
        Company databaseCompany = companyService.addCompany(company);
        return ResponseEntity.status(201).body(databaseCompany);
    }

    @PutMapping("/updateCompany")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        Company databaseCompany = companyService.updateCompany(company);
        return ResponseEntity.ok(databaseCompany);
    }

    @GetMapping("/getAllCompany")
    public ResponseEntity<List<Company>> getAllCompayn() {
        List<Company> companies = companyService.getAllCompany();
        return ResponseEntity.ok(companies);
    }

    @DeleteMapping("/deleteCompany/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.ok("Delete company");
    }
}
