package org.perscholas.daos;

import org.perscholas.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findEmployeeByemployeeEmail(final @NotBlank(message = "The Email Field is blank.") String employeeNumber);
}

