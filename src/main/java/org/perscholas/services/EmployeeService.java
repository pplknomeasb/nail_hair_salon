package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.daos.IEmployeeRepo;
import org.perscholas.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class EmployeeService {

    private final IEmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(IEmployeeRepo employeeRepo) {this.employeeRepo = employeeRepo; }

    public List<Employee> getEmployees() {return employeeRepo.findAll();}

    public Employee addNewEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepo.findEmployeeByemployeeEmail(employee.getEmployeeEmail());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException(employeeOptional + " is already in use.");
        }
        return employeeRepo.save(employee);
    }
}
