package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "Appointments")
@Data
//@RequiredArgsConstructor
@Getter@Setter
@NoArgsConstructor
//@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Appointment implements Serializable{

    @Id
    @NotBlank(message="Complete all fields to proceed.  Clients Email")
    String aClientEmail;

    @NotNull(message = "The date field has not been changed.") //@Size(min = 3, max = 25")

    //@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
    @Temporal(TemporalType.DATE)@DateTimeFormat(pattern="yyyy/MM/dd")
    Date aDateTime;

    @NotNull(message="Complete all fields to proceed. Event Type")
    String aEventType;

    @GeneratedValue(strategy= GenerationType.IDENTITY)//@Size(min =8)
    @NonNull Long aConfirmationNumber;



    //can be left blank or null
    Long aStylistEmpNumber;


    public Appointment(String aClientEmail, String aDateTime, String aEventType, long aStylistEmpNumber, long aConfirmationNumber) {

        this.aClientEmail = aClientEmail;

        try{
            this.aDateTime = new SimpleDateFormat("yyyy-MM-dd").parse(aDateTime);}
        catch(ParseException ex){
            log.info(ex.getMessage());
            throw new RuntimeException("ParseError");
        }

        this.aEventType = aEventType;
        this.aStylistEmpNumber = aStylistEmpNumber;
        this.aConfirmationNumber = aConfirmationNumber;
    }


}
