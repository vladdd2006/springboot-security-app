package com.javasampleapproach.springsecurity.jdbcauthentication.repositories;

import com.javasampleapproach.springsecurity.jdbcauthentication.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

}