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
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)@Size(min =12)
    Long cConfirmationNumber;

    @NotBlank(message = "The date field has not been changed.") //@Size(min = 3, max = 25, message = "Username must be between {2} and {1} Characters")
    //@Column(unique=true)
    //@UniqueConstraint()
    Date dateTime;

    @NotBlank(message="The Event field has not been changed.")
    String cLname;


    @NotBlank(message="A valid employee number is required.")
    Long cPhoneNum;



}
