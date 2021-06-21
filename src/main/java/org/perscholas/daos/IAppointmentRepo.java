package org.perscholas.daos;


import org.perscholas.models.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findByaConfirmationNumber(final @NotBlank(message = "The confirmation number field is blank.") Long clientConfirmationNumber);
}

