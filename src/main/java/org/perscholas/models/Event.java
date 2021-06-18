package org.perscholas.models;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Table(name = "Events")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Event implements Serializable{

    @Id
    @NonNull@NotBlank(message = "The event type field is blank")
    String eventType;

    @NonNull
    @NotBlank(message = "You must assign an Employee Number to the event.") //@Size(min = 3, max = 25, message = "Username must be between {2} and {1} Characters")
    //@Column(unique=true)
    //@UniqueConstraint()
    int eventEmployeeNumber;

    @NonNull
    @NotBlank(message="There isn't a cost in place for the event.")
    Double eventCost;


    @NonNull
    @NotBlank(message="You must insert a projected duration for the event.")
    Double eventDuration;

}
