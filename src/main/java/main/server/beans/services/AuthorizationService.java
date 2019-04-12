package main.server.beans.services;

import main.server.database.dto.User;

public interface AuthorizationService {

    User getUser(String login);

    long registerUser(User user);

    boolean isUserRegistered(String login);

}
