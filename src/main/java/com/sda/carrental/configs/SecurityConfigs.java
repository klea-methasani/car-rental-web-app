package com.sda.carrental.configs;

import com.mysql.cj.protocol.AuthenticationProvider;
import com.sda.carrental.models.enums.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfigs {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/api/branches/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/branches/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE, "/api/branches/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/api/branches/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/api/cars/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/cars/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE, "/api/cars/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/api/cars/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/api/rentals/**").permitAll()
                .requestMatchers(HttpMethod.PUT, "/api/rentals/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE, "/api/rentals/**").hasRole(UserRole.ADMIN.name())
                .requestMatchers(HttpMethod.GET, "/customers/**").hasRole(UserRole.USER.name())
                .requestMatchers(HttpMethod.PUT, "/customers/**").hasRole(UserRole.USER.name())
                .requestMatchers(HttpMethod.DELETE, "/customers/**").hasRole(UserRole.USER.name())
                .requestMatchers(HttpMethod.POST, "/customers/**").hasRole(UserRole.USER.name())
                .requestMatchers("/**", "/h2-console**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .logout()
                .logoutUrl("/auth/logout")
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
        return http.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

}