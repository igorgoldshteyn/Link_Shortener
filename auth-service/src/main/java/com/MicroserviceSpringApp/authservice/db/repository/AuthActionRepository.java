package com.MicroserviceSpringApp.authservice.db.repository;

import com.MicroserviceSpringApp.authservice.db.model.AuthAction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthActionRepository extends JpaRepository<AuthAction, Long> {

}
