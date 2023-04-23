package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.common.MsgEnum;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.exception.ApiException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * implement the EmployeeService
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    @Autowired
    public void EmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Get all employees
    @Override
    public List<Employee> retrieveEmployees() {
            return employeeRepository.findAll();
    }

    //Get the employee by employeeId
    @Override
    public Employee getEmployee(Long employeeId) {
        Optional<Employee> optEmp = employeeRepository.findById(employeeId);
        if (!optEmp.isPresent()) {
            throw new ApiException(MsgEnum.NOT_FOUND.getCode(), MsgEnum.NOT_FOUND.getMsg());
        }
        return optEmp.get();


    }

    //Add the employee
    @Override
    @Transactional
    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    //Delete the employee by employeeId
    @Override
    @Transactional
    public boolean deleteEmployee(Long employeeId){
        if (!employeeRepository.existsById(employeeId)) {
            throw new ApiException(MsgEnum.NOT_FOUND.getCode(), MsgEnum.NOT_FOUND.getMsg());
        }
        employeeRepository.deleteById(employeeId);
        return !employeeRepository.existsById(employeeId);
    }

    //Update the employee
    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        if (!employeeRepository.existsById(employee.getId())) {
            throw new ApiException(MsgEnum.NOT_FOUND.getCode(), MsgEnum.NOT_FOUND.getMsg());
        }
        return employeeRepository.save(employee);
    }

}