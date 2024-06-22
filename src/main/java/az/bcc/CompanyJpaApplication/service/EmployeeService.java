package az.bcc.CompanyJpaApplication.service;

import az.bcc.CompanyJpaApplication.entity.Employee;
import az.bcc.CompanyJpaApplication.exceptions.NotFoundException;
import az.bcc.CompanyJpaApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        employee.setId((long) 0);
        Employee databaseEmployee = employeeRepository.save(employee);
        return databaseEmployee;
    }

    public Employee updateEmployee(Employee employee) {
        if (employee.getId() != null) {
            Employee databaseEmployee = employeeRepository.save(employee);
            return databaseEmployee;
        }
        return null;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    public void deleteEmployee(Long id) {
        Optional<Employee> optEmployee = employeeRepository.findById(id);
        if (optEmployee.isEmpty()) {
            throw new NotFoundException("Employee is not found");
        }
        employeeRepository.deleteById(id);
    }
}
