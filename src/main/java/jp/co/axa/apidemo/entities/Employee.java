package jp.co.axa.apidemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *Employee JPA entity
 */
@Entity
@Table(name="EMPLOYEE")
public class Employee {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Name is mandatory")
    @Size(min = 4, max = 100, message = "Name must be between 4 and 100 characters")
    @Column(name="EMPLOYEE_NAME")
    private String name;

    @Getter
    @Setter
    @Column(name="EMPLOYEE_SALARY")
    private Integer salary;

    @Getter
    @Setter
    @Column(name="DEPARTMENT")
    private String department;

}
