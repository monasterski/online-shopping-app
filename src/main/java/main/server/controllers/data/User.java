package main.server.controllers.data;

public class User {

    private String username;
    private String password;
    private String userUrl = "https://static.thenounproject.com/png/1427-200.png";

    public User(){}

    public User(String username,String password, String userUrl){
        this.username = username;
        this.password = password;
        this.userUrl = userUrl;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String login) {
        this.username = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
