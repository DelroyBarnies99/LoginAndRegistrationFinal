package com.barnies.springboot.loginandreg.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.barnies.springboot.loginandreg.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByUsername(String username);
}
