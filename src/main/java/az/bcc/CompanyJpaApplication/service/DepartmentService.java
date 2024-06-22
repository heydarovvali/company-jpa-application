package az.bcc.CompanyJpaApplication.service;

import az.bcc.CompanyJpaApplication.entity.Department;
import az.bcc.CompanyJpaApplication.entity.Employee;
import az.bcc.CompanyJpaApplication.exceptions.NotFoundException;
import az.bcc.CompanyJpaApplication.repository.DepartmentRepository;
import az.bcc.CompanyJpaApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Department addDepartment(Department department) {
        department.setId((long) 0);
        Department databaseDepartment = departmentRepository.save(department);
        return databaseDepartment;
    }

    public Department updateDepartment(Department department) {
        if (department.getId() != null) {
            Department databsaDepartment = departmentRepository.save(department);
            return databsaDepartment;
        }
        return null;
    }

    public List<Department> getAllDepartment() {
        List<Department> departments = departmentRepository.findAll();
        return departments;
    }

    public void deleteDepartment(Long departmentId) {
        Optional<Department> optDepartment = departmentRepository.findById(departmentId);
        if (optDepartment.isEmpty()) {
            throw new NotFoundException("Department is not found");
        }
        if (optDepartment.isPresent()) {
            List<Employee> employees = employeeRepository.findAllByDepartment(optDepartment.get());
            for (int i = 0; i < employees.size(); i++) {
                Employee employee = employees.get(i);
                employeeRepository.deleteById(employee.getId());
            }
            departmentRepository.deleteById(departmentId);
        }
    }

}
