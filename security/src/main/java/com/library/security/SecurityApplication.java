package com.library.security;

import com.library.security.user.entity.Role;
import com.library.security.user.entity.User;
import com.library.security.user.entity.UserRole;
import com.library.security.user.exceptions.UserFoundException;
import com.library.security.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SecurityApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*try{
			User user = new User();
			user.setFirstName("Loui");
			user.setLastName("Velez");
			user.setUsername("Loui544");
			user.setPassword(passwordEncoder.encode("1234567"));
			user.setEmail("louivel4@gmail.com");
			Role rol = new Role();
			rol.setId(1L);
			rol.setName("ADMIN");
			Set<UserRole> userRoles = new HashSet<>();
			UserRole userRole = new UserRole();
			userRole.setRole(rol);
			userRole.setUser(user);
			userRoles.add(userRole);
			User saveUser = userService.saveUser(user,userRoles);
			System.out.println(saveUser.getUsername());
		}catch (UserFoundException exception){
			exception.printStackTrace();
		}*/
	}
}
