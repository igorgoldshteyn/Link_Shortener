package com.MicroserviceSpringApp.admininterface.db.repository;

import com.MicroserviceSpringApp.admininterface.db.model.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

    @Query(nativeQuery = true,
            value = "select * from admin_users ")
    Optional<List<AdminUser>> getAllAdminUsers();

    @Query(nativeQuery = true,
            value = "select * from admin_users where id = :id ")
    Optional<AdminUser> getAdminUserById(Long id);
}
