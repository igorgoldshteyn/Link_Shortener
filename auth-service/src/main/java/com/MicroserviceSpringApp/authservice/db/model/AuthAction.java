package com.MicroserviceSpringApp.authservice.db.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table
@Entity(name = "auth_actions")
public class AuthAction {

    /**
     * AuthAction id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * AuthAction type
     */
    @Column(name = "type")
    private String type;

    /**
     * AuthAction date
     */
    @Column(name = "date")
    private Date date;

    /**
     * AuthAction login
     */
    @Column(name = "login")
    private String login;

    /**
     * AuthAction password
     */
    @Column(name = "password")
    private String password;

    /**
     * AuthAction result
     */
    @Column(name = "result")

    private String result;

    /**
     * AuthAction reason
     */
    @Column(name = "reason")

    private String reason;


    //    todo: check if this is right
    public enum type {
        SIGN_IN,
        SIGN_UP,
        RESTORE_PASSWORD

    }

}
