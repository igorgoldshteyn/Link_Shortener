package com.MicroserviceSpringApp.authservice.utils;

import com.MicroserviceSpringApp.authservice.model.dto.ClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "client-interface", url = "http://localhost:8080", path = "/")
@Component
public interface FeignController {

    @GetMapping("/getCLientByLogin/{login}")
    ClientDto getCLientByLogin(@PathVariable("login") String login);


    @PostMapping("/addClient")
    ResponseEntity<?> addClient(@RequestBody ClientDto newClient);

}
