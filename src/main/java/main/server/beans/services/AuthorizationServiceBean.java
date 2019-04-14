package main.server.beans.services;

import main.server.controllers.data.User;
import main.server.database.dao.UserDAO;
import main.server.database.dto.UserData;

public class AuthorizationServiceBean implements AuthorizationService {

    @Override
    public User getUser(String username) {
        UserData data = UserDAO.getInstance().getItem(username);
        return new User(data.getUsername(),data.getPassword());
    }

    @Override
    public long registerUser(User user) {
        UserData data = new UserData();
        data.setUsername(user.getUsername());
        data.setPassword(user.getPassword());
        UserDAO.getInstance().createItem(data);
        return data.getId();
    }

    @Override
    public boolean isUserRegistered(String username) {
        return getUser(username) == null;
    }
}
