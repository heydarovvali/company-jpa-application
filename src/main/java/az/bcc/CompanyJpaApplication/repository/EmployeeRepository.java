package az.bcc.CompanyJpaApplication.repository;

import az.bcc.CompanyJpaApplication.entity.Department;
import az.bcc.CompanyJpaApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findAllByDepartment(Department department);
}
