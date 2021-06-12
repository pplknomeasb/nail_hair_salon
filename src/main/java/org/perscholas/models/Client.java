package org.perscholas.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Table(name = "Client")
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long cConfirmationNumber;

    @NotBlank(message = "The First Name Field is blank.") //@Size(min = 3, max = 25, message = "Username must be between {2} and {1} Characters")
    //@Column(unique=true)
    //@UniqueConstraint()
    String cFname;

    @NotBlank(message="The Last Name Field is blank.")
    String cLname;


    @NotBlank(message="The Phone Number Field is blank.")
    Long cPhoneNum;

    @NotBlank(message ="The Email Field is blank.")
    String clientEmail;


}
