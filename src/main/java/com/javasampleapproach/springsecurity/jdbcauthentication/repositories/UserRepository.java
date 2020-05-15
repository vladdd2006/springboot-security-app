package com.javasampleapproach.springsecurity.jdbcauthentication.repositories;

import com.javasampleapproach.springsecurity.jdbcauthentication.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByUsername(String username);

}