package main.server.beans.services;

import main.server.controllers.data.User;

public interface AuthorizationService {

    User getUser(String login);

    long registerUser(User user);

    boolean isUserRegistered(String login);

}
