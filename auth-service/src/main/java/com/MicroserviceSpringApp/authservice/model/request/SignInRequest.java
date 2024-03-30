package com.MicroserviceSpringApp.authservice.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignInRequest {
    private String login;
    private String password;

}
