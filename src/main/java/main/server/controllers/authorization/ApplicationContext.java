package main.server.controllers.authorization;

public class ApplicationContext {

    private String username;

    public ApplicationContext(){}

    public String getUsername() {
        return username;
    }

    void initContext(String username){
        this.username = username;
    }
}
