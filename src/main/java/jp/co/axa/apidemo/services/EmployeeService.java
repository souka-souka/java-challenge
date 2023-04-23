package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

/**
 * EmployeeService interface
 */
public interface EmployeeService {

    //Get all employees
    public List<Employee> retrieveEmployees();

    //Get the employee by employeeId
    public Employee getEmployee(Long employeeId);

    //Add the employee
    public Employee saveEmployee(Employee employee);

    //Delete the employee by employeeId
    public boolean deleteEmployee(Long employeeId);

    //Update the employee
    public Employee updateEmployee(Employee employee);
}