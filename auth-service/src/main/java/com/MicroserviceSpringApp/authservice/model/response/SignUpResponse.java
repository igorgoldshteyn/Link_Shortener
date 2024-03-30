package com.MicroserviceSpringApp.authservice.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignUpResponse {
    private String result;
    private String reason;
}
