package main.server.beans.services;

import main.server.database.dto.User;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthorizationService {

    User getUser(String login);

    long registerUser(User user);

    boolean isUserRegistered(String login);

}
