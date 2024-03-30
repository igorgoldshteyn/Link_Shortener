package com.MicroserviceSpringApp.authservice.api;

import com.MicroserviceSpringApp.authservice.AuthServiceApplication;
import com.MicroserviceSpringApp.authservice.db.model.AuthAction;
import com.MicroserviceSpringApp.authservice.db.repository.AuthActionRepository;
import com.MicroserviceSpringApp.authservice.model.dto.ClientDto;
import com.MicroserviceSpringApp.authservice.model.request.SignInRequest;
import com.MicroserviceSpringApp.authservice.model.request.SignUpRequest;
import com.MicroserviceSpringApp.authservice.model.response.SignInResponse;
import com.MicroserviceSpringApp.authservice.model.response.SignUpResponse;
import com.MicroserviceSpringApp.authservice.service.AuthService;
import com.MicroserviceSpringApp.authservice.utils.FeignController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@Tag(name = "Auth service controller", description = "Auth service controller")
public class AuthServiceController {

    @Autowired
    AuthService authService;
    @Autowired
    private FeignController clientController;
    @Autowired
    AuthActionRepository authActionRepository;

    private static final Logger logger = LogManager.getLogger(AuthServiceApplication.class);

    private final String ALLOW_TO_SIGN_IN = "ALLOW";
    private final String REJECT_TO_SIGN = "REJECTED";

    @PostMapping("/signIn")
    @Operation(summary = "Sign in")
    public SignInResponse signIn(@RequestBody SignInRequest request) {
        logger.info("Sign in. Login: " + request.getLogin());

        ClientDto client = clientController.getCLientByLogin(request.getLogin());

        SignInResponse signInResponse;
        AuthAction authAction;

        if (client == null) {
            signInResponse = SignInResponse.builder().result(REJECT_TO_SIGN).reason("No such client").build();
        } else if (!client.getPassword().equals(request.getPassword())) {
            signInResponse = SignInResponse.builder().result(REJECT_TO_SIGN).reason("Wrong password").build();
        } else {
            signInResponse = SignInResponse.builder().result(ALLOW_TO_SIGN_IN).build();
        }

        authAction = AuthAction.builder().date(new Date()).type("Sign in").result(signInResponse.getResult())
                .reason(signInResponse.getReason()).login(request.getLogin()).password(request.getPassword()).build();
        authActionRepository.save(authAction);

        return signInResponse;

    }

    @PostMapping("signUp")
    @Operation(summary = "Sign up")
    public SignUpResponse signUp(@RequestBody SignUpRequest request) {
        logger.info("Sign up. Client: " + request.getFirstName() + " " + request.getFirstName());

        SignUpResponse signUpResponse;
        AuthAction authAction;

        if (clientController.getCLientByLogin(request.getLogin()) == null) {
            signUpResponse = SignUpResponse.builder()
                    .result("OK")
                    .reason("")
                    .build();

        } else {
            signUpResponse = SignUpResponse.builder()
                    .result("ERROR")
                    .reason("This login is registered")
                    .build();
        }

        ClientDto client = ClientDto.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .login(request.getLogin())
                .password(request.getPassword())
                .dateOfBirth(request.getDateOfBirth())
                .build();

        clientController.addClient(client);

        authAction = AuthAction.builder()
                .result(signUpResponse.getResult())
                .reason(signUpResponse.getReason())
                .login(request.getLogin())
                .password(request.getPassword())
                .type("Sign up")
                .date(new Date())
                .build();
        authActionRepository.save(authAction);

        return signUpResponse;
    }

    @PostMapping("/restorePassword/")
    @Operation(summary = "Restore password")
    public String restorePassword(String login) {
        logger.info("Restore password. Login: " + login);

        return "";
    }


}
