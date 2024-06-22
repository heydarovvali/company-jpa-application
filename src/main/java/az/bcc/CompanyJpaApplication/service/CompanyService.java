package az.bcc.CompanyJpaApplication.service;

import az.bcc.CompanyJpaApplication.entity.Company;
import az.bcc.CompanyJpaApplication.entity.Department;
import az.bcc.CompanyJpaApplication.exceptions.NotFoundException;
import az.bcc.CompanyJpaApplication.repository.CompanyRepository;
import az.bcc.CompanyJpaApplication.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private DepartmentService departmentService;

    public Company addCompany(Company company) {
        company.setId((long) 0);
        Company databaseCompany = companyRepository.save(company);
        return databaseCompany;
    }

    public Company updateCompany(Company company) {
        if (company.getId() != null) {
            Optional<Company> optCompany = companyRepository.findById(company.getId());
            if (optCompany.isEmpty()) {
                throw new NotFoundException("Company is not found");
            }
            Company databaseCompayn = companyRepository.save(company);
            return databaseCompayn;
        }
        return null;
    }

    public List<Company> getAllCompany() {
        List<Company> companies = companyRepository.findAll();
        return companies;
    }

    public void deleteCompany(Long companyId) {
        Optional<Company> optCompany = companyRepository.findById(companyId);
        if (optCompany.isEmpty()) {
            throw new NotFoundException("Company with this id is not found");
        }
        if (optCompany.isPresent()) {
            List<Department> departments = departmentRepository.findAllByCompany(optCompany.get());
            for (int i = 0; i < departments.size(); i++) {
                Department department = departments.get(i);
                departmentService.deleteDepartment(department.getId());

            }
            companyRepository.deleteById(companyId);
        }
    }
}
