package az.bcc.CompanyJpaApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Integer experienceYear;
    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id")
    private Department department;
}
