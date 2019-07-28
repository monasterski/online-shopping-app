package main.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.mem.InMemoryUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;


import javax.inject.Inject;
import javax.sql.DataSource;
import java.util.Objects;

@Configuration
public class SocialConfig extends SocialConfigurerAdapter {


    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(
                Objects.requireNonNull(environment.getProperty("spring.social.facebook.appId")),
                Objects.requireNonNull(environment.getProperty("spring.social.facebook.appSecret"))));
        return registry;
    }

    @Inject
    private Environment environment;


    @Bean
    public UsersConnectionRepository usersConnectionRepository (ConnectionFactoryLocator connectionFactoryLocator) {
        InMemoryUsersConnectionRepository repository = new InMemoryUsersConnectionRepository(connectionFactoryLocator);
        return repository;
    }

}
