package org.perscholas.daos;

import org.perscholas.models.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface IClientRepo extends JpaRepository<Client, Long> {
    Optional<Client> findClientByclientEmail(final @NotBlank(message = "The Email Field is blank.") String employeeEmail);
}

