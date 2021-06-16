package org.perscholas.daos;

import org.perscholas.models.Appointment;
import org.perscholas.models.Employee;
import org.perscholas.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findAppointmentByConfirmationNumber(final @NotBlank(message = "A valid confirmation number must be entered.") Long appointmentConfirmationNumber);
}

