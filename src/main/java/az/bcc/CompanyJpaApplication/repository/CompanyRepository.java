package az.bcc.CompanyJpaApplication.repository;

import az.bcc.CompanyJpaApplication.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
