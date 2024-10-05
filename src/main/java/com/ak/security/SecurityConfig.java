package com.ak.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(authorize -> authorize
	            .requestMatchers("/login").permitAll()
	            .requestMatchers("/admin/**").hasRole("ADMINISTRATOR") // Only ADMINISTRATOR can access /admin URLs
	            .requestMatchers("/faculty/**").hasRole("FACULTY_MEMBER")
	            .requestMatchers("/student/**").hasRole("STUDENT")
	            .anyRequest().authenticated()
	        )
	        .formLogin(form -> form
	            .loginPage("/login")
	            .permitAll()
	            .successHandler((request, response, authentication) -> {
	                String role = authentication.getAuthorities().stream()
	                    .map(GrantedAuthority::getAuthority)
	                    .findFirst()
	                    .orElse("ROLE_USER");

	                switch (role) {
	                    case "ROLE_ADMINISTRATOR":
	                        response.sendRedirect("/admin/dashboard");
	                        break;
	                    case "ROLE_FACULTY_MEMBER":
	                        response.sendRedirect("/faculty/dashboard");
	                        break;
	                    case "ROLE_STUDENT":
	                        response.sendRedirect("/student/dashboard");
	                        break;
	                    default:
	                        response.sendRedirect("/");
	                        break;
	                }
	            })
	            .failureUrl("/login?error=true")
	        )
	        .logout(logout -> logout.permitAll());

	    return http.build();
	}


    // Define a user details service for in-memory authentication for testing purposes
	@Bean
	public UserDetailsService userDetailsService() {
	    UserDetails student = User.withUsername("student")
	            .password(passwordEncoder().encode("password"))
	            .roles("STUDENT")
	            .build();

	    UserDetails faculty = User.withUsername("faculty")
	            .password(passwordEncoder().encode("password"))
	            .roles("FACULTY_MEMBER")
	            .build();

	    UserDetails admin = User.withUsername("admin")
	            .password(passwordEncoder().encode("password"))
	            .roles("ADMINISTRATOR")
	            .build();

	    return new InMemoryUserDetailsManager(student, faculty, admin);
	}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Use BCrypt for password encoding
    }
    
}