package org.perscholas.daos;

import org.perscholas.models.Employee;
import org.perscholas.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface IEventRepo extends JpaRepository<Event, String> {
    Optional<Event> findEventByeventType(final @NotBlank(message = "The event type is empty.") String eventType);
}

