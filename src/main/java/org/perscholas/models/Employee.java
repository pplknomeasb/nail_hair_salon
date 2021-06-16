package org.perscholas.models;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Table(name = "Employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long employeeNumber;

    @NotBlank@NotNull(message = "The First Name Field is blank.") //@Size(min = 3, max = 25, message = "Username must be between {2} and {1} Characters")
    //@Column(unique=true)
    //@UniqueConstraint()
    String eFname;

    @NotBlank@NotNull(message="The Last Name Field is blank.")
    String eLname;


    @NotBlank@NotNull(message="The Phone Number Field is blank.")
    Long ePhoneNum;

    @Column(unique = true)@NotNull
    @NotBlank(message ="The Email Field is blank.")
    String employeeEmail;

    @NotBlank@NotNull(message="You must select a User Type.")
    String eUserType;



}
