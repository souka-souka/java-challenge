package jp.co.axa.apidemo.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import jp.co.axa.apidemo.common.ResultBody;
import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/employees")
@Api(value = "Employees Management System")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public void EmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get")
    @ApiOperation(value = "Get all employees")
    public ResultBody getEmployees() {
        return ResultBody.ok().data("items",employeeService.retrieveEmployees());
    }

    @GetMapping("/get/{employeeId}")
    @ApiOperation(value = "Get employee data with specified id")
    public ResultBody getEmployee(@PathVariable(name="employeeId", required = true)Long employeeId) {
        return ResultBody.ok().data("employee",employeeService.getEmployee(employeeId));
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Add a new employee")
    public ResultBody saveEmployee(@Validated @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResultBody.error().messageList(errors);
        }
        return ResultBody.ok().data("employee",employeeService.saveEmployee(employee));
    }

    @DeleteMapping("/delete/{employeeId}")
    @ApiOperation(value = "Delete employee data with specified id")
    public ResultBody deleteEmployee(@ApiParam(name =  "employeeId", value = "Employee id", example = "1", required = true)
                                         @PathVariable(name="employeeId", required = true)Long employeeId) {
        boolean flag = employeeService.deleteEmployee(employeeId);
        if(flag){
            return ResultBody.ok();
        }else{
            return ResultBody.error();
        }
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update employee with provided information")
    public ResultBody updateEmployee(@Validated @RequestBody Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            return ResultBody.error().messageList(errors);
        }
        return ResultBody.ok().data("employee",employeeService.updateEmployee(employee));
    }

}
