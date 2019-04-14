package main.server.database.dto;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserData {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "USER_LOGIN")
    private String login;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_ROLE")
    private int userRole;


    public UserData() {
        this.login = "login";
        this.password = "pass";
    }

    public UserData(String login,String password){
        this.login = login;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}