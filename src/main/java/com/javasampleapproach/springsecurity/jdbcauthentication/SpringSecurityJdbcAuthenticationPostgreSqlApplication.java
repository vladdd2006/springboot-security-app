package com.javasampleapproach.springsecurity.jdbcauthentication;

import com.javasampleapproach.springsecurity.jdbcauthentication.entities.Role;
import com.javasampleapproach.springsecurity.jdbcauthentication.entities.User;
import com.javasampleapproach.springsecurity.jdbcauthentication.repositories.RoleRepository;
import com.javasampleapproach.springsecurity.jdbcauthentication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringSecurityJdbcAuthenticationPostgreSqlApplication {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcAuthenticationPostgreSqlApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void testJpaMethods(){
		Role role = roleRepository.findOne("ADMIN");
		if (role == null) {
			role = new Role();
			role.setName("ADMIN");
			roleRepository.save(role);
		}

		User user = userRepository.findOne("admin");
		if (user == null) {
			user = new User();
			user.setUsername("admin");
			user.setFirstName("admin");
			user.setLastName("admin");
			user.setPassword("123456");
			List<Role> roles = new ArrayList<>();
			roles.add(role);
			user.setRole(roles);
			userRepository.save(user);
		}
	}
}
