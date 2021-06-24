package org.perscholas.services;

import lombok.extern.java.Log;
import org.perscholas.daos.IEmployeeRepo;
import org.perscholas.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class EmployeeService {

    private final IEmployeeRepo employeeRepo;

    //injecting pointer object into employeeRepo
    @Autowired
    public EmployeeService(IEmployeeRepo employeeRepo) {this.employeeRepo = employeeRepo; }

    public List<Employee> getAllEmployees() {return employeeRepo.findAll();}

    public Employee addNewEmployee(Employee employee){
        Optional<Employee> employeeOptional = employeeRepo.findEmployeeByemployeeNumber(employee.getEmployeeNumber());
        if(employeeOptional.isPresent()){
            throw new IllegalStateException(employeeOptional + " is already in use.");
        }
        log.info(employee + " was added");

        return employeeRepo.save(employee);
    }

    public void updateEmployee(Long employeeNumber, String fName, String lName, Long phoneNum, String email, String userType, String password){

        boolean exists = employeeRepo.existsById(employeeNumber);
        if(exists){
            Employee employee = employeeRepo.findEmployeeByemployeeNumber(employeeNumber).get();
            log.info("Employee was updated");
            employee.setEFname(fName);
            employee.setELname(lName);
            employee.setEPhoneNum(phoneNum);
            employee.setEmployeeEmail(email);
            employee.setEUserType(userType);
            employee.setEPassword(password);

        }


    }

    @Transactional
    public void removeEmployee(Long employeeNumber){
        Optional<Employee> employeeOptional = employeeRepo.findEmployeeByemployeeNumber(employeeNumber);
        boolean exists = employeeRepo.existsById(employeeNumber);
        if(exists){
            log.info("Employee with id " + employeeNumber + " has been removed");
            employeeRepo.deleteById(employeeNumber);
        }
    }

}
