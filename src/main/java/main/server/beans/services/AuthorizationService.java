package main.server.beans.services;

import main.server.database.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface AuthorizationService {

    User getUser(String login);

    long registerUser(User user);

    boolean isUserRegistered(String login);

}
