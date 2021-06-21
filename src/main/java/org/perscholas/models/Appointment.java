package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "Appointments")
@Data
@RequiredArgsConstructor
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Appointment implements Serializable{

    @Id
    @NotBlank(message="Complete all fields to proceed.  Clients Email")
    String aClientEmail;

    @NotBlank(message = "The date field has not been changed.") //@Size(min = 3, max = 25")
    @Temporal(TemporalType.DATE)
    Date aDateTime;

    @NotBlank(message="Complete all fields to proceed. Event Type")
    Long aEventType;

    @GeneratedValue(strategy= GenerationType.IDENTITY)//@Size(min =8)
    @NotBlank@NonNull Long aConfirmationNumber;



    //can be left blank or null
    Long aStylistEmpNumber;


    public Appointment(String aClientEmail, Date aDateTime, long aEventType, long aStylistEmpNumber, long aConfirmationNumber) {

        this.aClientEmail = aClientEmail;
        this.aDateTime = aDateTime;
        this.aEventType = aEventType;
        this.aStylistEmpNumber = aStylistEmpNumber;
        this.aConfirmationNumber = aConfirmationNumber;
    }


}
