package com.example.spring_security_thymeleaf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain config(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(authorize -> authorize
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/").permitAll()
					.requestMatchers("/about").permitAll()
					.requestMatchers("/dashboard").hasAnyAuthority("VIEW_STORE")
					.anyRequest().authenticated()
			)
			.formLogin(form -> form
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/dashboard")
					.permitAll()
			);
		
		return http.build();
	}
}
