package az.bcc.CompanyJpaApplication.repository;

import az.bcc.CompanyJpaApplication.entity.Company;
import az.bcc.CompanyJpaApplication.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public List<Department> findAllByCompany(Company company);
}
