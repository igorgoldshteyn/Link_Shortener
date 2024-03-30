package com.MicroserviceSpringApp.clientInterface.db.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Table
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clients")
public class Client {

    /**
     * Client id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Client first name
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Client last name
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * Client email
     */
    @Column(name = "email")
    private String email;

    /**
     * Client login
     */
    @Column(name = "login")
    private String login;

    /**
     * Client password
     */
    @Column(name = "password")
    private String password;

    /**
     * Client date of birth
     */
    @Column(name = "date_of_birth")
    private Date dateOfBirth;


}
