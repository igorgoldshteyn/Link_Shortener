package com.MicroserviceSpringApp.clientInterface.db.repository;

import com.MicroserviceSpringApp.clientInterface.db.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(nativeQuery = true,
            value = "select * from clients ")
    Optional<List<Client>> getAllClients();

    @Query(nativeQuery = true,
            value = "select * from clients where id = :id ")
    Optional<Client> getClientById(Long id);
    @Query(nativeQuery = true,
            value = "select * from clients where login = :login ")
    Optional<Client> getClientByLogin(String login);
}
