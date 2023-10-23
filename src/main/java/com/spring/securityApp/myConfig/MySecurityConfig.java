package com.spring.securityApp.myConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public UserDetailsService service(){

        UserDetails user1 = User
                .withUsername("root")
                .password(passwordEncoder().encode("root"))
                .roles("developer")
                .build();

        UserDetails user2 = User.builder()
                .username("root1")
                .password(passwordEncoder().encode("root1"))
                .roles("developer")
                .build();



        return new InMemoryUserDetailsManager(user1,user2);

    }

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/users/public")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();

        return http.build();
    }
}
