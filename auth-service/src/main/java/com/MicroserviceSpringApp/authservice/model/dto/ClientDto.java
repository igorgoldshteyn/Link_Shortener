package com.MicroserviceSpringApp.authservice.model.dto;

import jakarta.persistence.Column;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDto {

    private String firstName;

    private String lastName;

    private String email;

    private String login;

    private String password;

    private Date dateOfBirth;

}
