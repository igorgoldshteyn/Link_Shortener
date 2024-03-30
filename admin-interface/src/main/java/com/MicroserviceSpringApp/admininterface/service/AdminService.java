package com.MicroserviceSpringApp.admininterface.service;

import com.MicroserviceSpringApp.admininterface.db.model.AdminUser;
import com.MicroserviceSpringApp.admininterface.db.repository.AdminUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminUserRepository adminUserRepository;

    /**
     * add adminUser
     *
     * @param adminUser
     * @return response
     */

    public ResponseEntity<?> addAdminUser(AdminUser adminUser) {
        adminUserRepository.save(adminUser);
        return ResponseEntity.status(HttpStatus.OK)
                .body(adminUser);
    }

    /**
     * add multiple adminUsers
     *
     * @param adminUserList
     * @return response
     */

    public ResponseEntity<?> addAdminUsers(List<AdminUser> adminUserList) {
        adminUserRepository.saveAll(adminUserList);
        return ResponseEntity.status(HttpStatus.OK).body(adminUserList);
    }

    /**
     * remove adminUser by id
     *
     * @param id
     * @return response
     */

    public ResponseEntity<?> removeAdminUserById(long id) {
        adminUserRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Removed");
    }

    /**
     * updates a adminUser if it is in the database. Validation throught adminUser.Id
     *
     * @param adminUser
     * @return response
     */
    public ResponseEntity<?> updateAdminUserById(AdminUser adminUser) {
        Optional<AdminUser> adminUserToUpdate = adminUserRepository.getAdminUserById(adminUser.getId());
        if (adminUserToUpdate.isPresent()) {
            adminUserRepository.save(adminUser);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(adminUser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No such adminUser");
        }
    }
}
