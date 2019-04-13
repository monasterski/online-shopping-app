package main.server.controllers;

import main.server.controllers.authorization.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractController {

    @Autowired
    private ApplicationContext applicationContext;

    protected ApplicationContext getApplicationContext() {
        return applicationContext;
    }
}
