package com.MicroserviceSpringApp.authservice.model.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignUpRequest {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;


}
