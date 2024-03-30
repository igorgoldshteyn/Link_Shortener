package com.MicroserviceSpringApp.clientInterface.service;

import com.MicroserviceSpringApp.clientInterface.db.model.Client;
import com.MicroserviceSpringApp.clientInterface.db.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    /**
     * add client
     *
     * @param client
     * @return response
     */

    public ResponseEntity<?> addClient(Client client) {
        clientRepository.save(client);
        return ResponseEntity.status(HttpStatus.OK)
                .body(client);
    }

    /**
     * add multiple clients
     *
     * @param clientList
     * @return response
     */

    public ResponseEntity<?> addClients(List<Client> clientList) {
        clientRepository.saveAll(clientList);
        return ResponseEntity.status(HttpStatus.OK).body(clientList);
    }

    /**
     * remove client by id
     *
     * @param id
     * @return response
     */

    public ResponseEntity<?> removeClientById(long id) {
        clientRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Removed");
    }

    /**
     * updates a client if it is in the database. Validation through client.Id
     *
     * @param client
     * @return response
     */
    public ResponseEntity<?> updateClientById(Client client) {
        Optional<Client> clientToUpdate = clientRepository.getClientById(client.getId());
        if (clientToUpdate.isPresent()) {
            clientRepository.save(client);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(client);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such client");
        }
    }
}
