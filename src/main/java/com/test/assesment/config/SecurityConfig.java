package com.test.assesment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Adding roles and credentials to secure the endpoint using spring security
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails user1= User.builder()
                .username("user")
                .password("{noop}password")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1);
    }

    //Adding Role based access for APIs and enabling swagger access
    @Bean
    public SecurityFilterChain filterChain (HttpSecurity security) throws Exception{

        security.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers("/service/contact/**").hasRole("ADMIN")
                        .requestMatchers("/swagger-ui/**").hasAnyRole("ADMIN")
                        .requestMatchers("/v3/**").hasAnyRole("ADMIN")

        );
        security.httpBasic();
        //Disabled the cross site scripting
        security.csrf().disable();
        return security.build();

    }
}
