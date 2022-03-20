package com.example.jpa_tp5;

import com.example.jpa_tp5.entites.Role;
import com.example.jpa_tp5.entites.User;
import com.example.jpa_tp5.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaTp5Application {

	public static void main(String[] args) {
		SpringApplication.run(JpaTp5Application.class, args);
	}
	@Bean
	CommandLineRunner start(UserService userService){
		return args -> {
			User u=new User();
			u.setUsername("user1");
			u.setPassword("123456");
			userService.addNewUser(u);

			User u1=new User();
			u1.setUsername("admin");
			u1.setPassword("123456");
			userService.addNewUser(u1);

			Stream.of("STUDENT","USER","ADMIN").forEach(r->{
				Role role1 = new Role();
				role1.setRoleName(r);
				userService.addNewRole(role1);
			});

			userService.addRoleToUser("user1","STUDENT");
			userService.addRoleToUser("user1","USER");
			userService.addRoleToUser("admin","ADMIN");
			userService.addRoleToUser("admin","USER");

			try {
				User user=userService.authenticate("user1","123456");
				System.out.println(user.getUserID());
				System.out.println(user.getUsername());
				System.out.println("Roles ==> ");
				user.getRoles().forEach(r->{
					System.out.println("Roles ==> "+r.toString());
				});
			}
			catch (Exception exception){
				exception.printStackTrace();
			}
		};
	}
}
