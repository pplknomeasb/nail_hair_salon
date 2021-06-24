package org.perscholas.models;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Table(name = "Employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Log
@Component

public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    Long employeeNumber;
    @NonNull
    @NotBlank@NotNull(message = "The First Name Field is blank.")
    String eFname;

    @NonNull
    @NotBlank@NotNull(message="The Last Name Field is blank.")
    String eLname;

    @NonNull
    @NotNull(message="The Phone Number Field is blank.")
    Long ePhoneNum;

    @NonNull
    @Column(unique = true)@NotNull
    @NotBlank(message ="The Email Field is blank.")
    String employeeEmail;

    @NonNull
    @NotBlank@NotNull(message="You must select a User Type.")
    String eUserType;

    @NonNull@NotBlank(message="You must enter a password")
    String ePassword;

}
