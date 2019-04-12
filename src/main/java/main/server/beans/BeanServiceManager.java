package main.server.beans;

import main.A_TO_REMOVE_MOCK.AuthorizationServiceBeanMOCK;
import main.configuration.security.HashPasswordEncoder;
import main.configuration.security.UserLoginService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetailsService;
import main.server.beans.services.AuthorizationService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanServiceManager {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserLoginService();
    }

    @Bean
    public AuthorizationService authorizationService(){
        return new AuthorizationServiceBeanMOCK();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new HashPasswordEncoder();
    }
}
