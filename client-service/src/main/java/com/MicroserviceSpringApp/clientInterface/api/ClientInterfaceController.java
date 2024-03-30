package com.MicroserviceSpringApp.clientInterface.api;

import com.MicroserviceSpringApp.clientInterface.ClientInterfaceApplication;
import com.MicroserviceSpringApp.clientInterface.db.model.Client;
import com.MicroserviceSpringApp.clientInterface.db.repository.ClientRepository;
import com.MicroserviceSpringApp.clientInterface.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name="Client Interface Controller", description="Client Interface Controller")
public class ClientInterfaceController {

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    private static final Logger logger = LogManager.getLogger(ClientInterfaceApplication.class);


    @GetMapping("/getCLientById/{id}")
    @Operation(
            summary = "Get client by Id"
    )
    public Optional<Client> getCLientById(@PathVariable("id") long id) {
        logger.info("GET REQUEST: /getCLientById/" + id); // todo refactor
        return clientRepository.getClientById(id);
    }

    @GetMapping("/getCLientByLogin/{login}")
    @Operation(
            summary = "Get client by login"
    )
    public Optional<Client> getCLientByLogin(@PathVariable("login") String login) {
        logger.info("GET REQUEST: /getCLientByLogin/" + login);
        return clientRepository.getClientByLogin(login);
    }

    @GetMapping("/getAllClients")
    @Operation(
            summary = "Вывести всех клиентов"
    )
    @CrossOrigin
    public Optional<List<Client>> getAllClients() {
        System.out.println("ClientInterfaceController.getAllClients");
        logger.info("GET REQUEST: /getAllClients");
        return clientRepository.getAllClients();
    }

    @PostMapping("/addClient")
    @Operation(summary = "Add client")
    public ResponseEntity<?> addClient(@RequestBody Client  client) {
        logger.info("POST REQUEST: /addClient");

        return clientService.addClient(client);
    }

    @PostMapping("/addClients")
    @Operation(summary = "Add multiple client")
    public ResponseEntity<?> addClients(@RequestBody List<Client> clientList) {
        logger.info("POST REQUEST: /addClients");
        return clientService.addClients(clientList);
    }

    @DeleteMapping("/removeClientById/{id}")
    @Operation(summary = "Remove client by Id ")
    public ResponseEntity<?> removeClientById(@PathVariable("id") long id) {
        logger.info("DELETE REQUEST: /removeClientById/" + id);
        return clientService.removeClientById(id);
    }

    @PutMapping("/updateClient/{id}") //todo chePutMapping if Put is siutable
    public ResponseEntity<?> updateClient(@RequestBody Client client) {
        logger.info("UPDATE REQUEST: updateClient/");
        return clientService.updateClientById(client);
    }
}
