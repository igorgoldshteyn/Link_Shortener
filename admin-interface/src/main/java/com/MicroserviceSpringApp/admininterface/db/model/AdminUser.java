package com.MicroserviceSpringApp.admininterface.db.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "admin_users")
public class AdminUser {

    /**
     * AdminUser id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * AdminUser first name
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * AdminUser last name
     */
    @Column(name = "last_name")
    private String lastName;

    /**
     * AdminUser email
     */
    @Column(name = "email")
    private String email;

    /**
     * AdminUser password
     */
    @Column(name = "password")
    private String password;

}
