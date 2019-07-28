package main.server.beans.services;

import main.server.controllers.authorization.ApplicationContext;
import main.server.controllers.data.User;
import main.server.database.dao.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Service;

@Service
public class FacebookConnectionSignup implements ConnectionSignUp {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private UserRepository userRepository;

    @Override
    public String execute(Connection<?> connection) {
        User user = new User();
        String userName = connection.getDisplayName().replace(" ", "");
        user.setUsername(userName);
        user.setPassword(RandomStringUtils.randomAlphabetic(8));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        authorizationService.registerUser(user);
        context.initContext(userRepository.getItem(userName));
        return user.getUsername();
    }
}
