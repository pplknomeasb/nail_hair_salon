package org.perscholas.models;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "Clients")
@Data
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)@Size(min =8)
    Long cConfirmationNumber;

    @NotBlank(message = "The date field has not been changed.") //@Size(min = 3, max = 25")
    //@Column(unique=true)
    //@UniqueConstraint()
    Date cDateTime;

    @NotBlank(message="Complete all fields to proceed. First Name")
    String cFname;

    @NotBlank(message="Complete all fields to proceed.  Email")
    String clientEmail;

    @NotBlank(message="Complete all fields to proceed. Last Name")
    String cLname;


    @NotBlank(message="A valid client number is required.")
    Long cPhoneNum;



}
