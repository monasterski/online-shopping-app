package main.A_TO_REMOVE_MOCK;

import main.server.beans.services.AuthorizationService;
import main.server.database.dto.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;

public class AuthorizationServiceBeanMOCK implements AuthorizationService {

    private static long id = 0;
    private HashMap<String, User> map = new HashMap();

    @Override
    public User getUser(String username) {
        return map.get(username);
    }

    @Override
    public long registerUser(User user) {
        user.setId(id++);
        map.put(user.getUsername(),user);
        return id;
    }

    @Override
    public boolean isUserRegistered(String username) {
        return map.containsKey(username);
    }
}
