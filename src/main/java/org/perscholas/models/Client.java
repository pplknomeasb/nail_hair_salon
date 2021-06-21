package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Table(name = "Clients")
@Data
@RequiredArgsConstructor
@Getter@Setter
//@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//@Size(min =8)
    Long cConfirmationNumber;

    //@NotBlank(message = "The date field has not been changed.") //@Size(min = 3, max = 25")
    //@Column(unique=true)
    //@UniqueConstraint()
    @Temporal(TemporalType.DATE)
            //@DateTimeFormat(pattern="YYYY-MM-DD")
    Date cDateTime;

    @NotBlank(message="Complete all fields to proceed. First Name")
    String cFname;



    @NotBlank(message="Complete all fields to proceed. Last Name")
    String cLname;

    @NotBlank(message="Complete all fields to proceed.  Email")
    String clientEmail;

    @NotNull(message="A valid client number is required.")
    Long cPhoneNum;


    public Client(Date cDateTime, String cFname, String cLname, String clientEmail, long cPhoneNum) {

        this.cDateTime = cDateTime;
        this.cFname = cFname;
        this.cLname = cLname;
        this.clientEmail = clientEmail;
        this.cPhoneNum = cPhoneNum;
    }

    public Client(String cDateTime, String cFname, String cLname, String clientEmail, long cPhoneNum) {

        try{
        this.cDateTime = new SimpleDateFormat("yyyy-MM-dd").parse(cDateTime);}
        catch(ParseException ex){
            log.info(ex.getMessage());
            throw new RuntimeException("ParseError");
        }

        this.cFname = cFname;
        this.cLname = cLname;
        this.clientEmail = clientEmail;
        this.cPhoneNum = cPhoneNum;
    }
}
