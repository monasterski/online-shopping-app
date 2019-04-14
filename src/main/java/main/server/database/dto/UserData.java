package main.server.database.dto;

import main.server.database.AbstractData;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
public class UserData extends AbstractData {

    @Id
    @Column(name = "USER_ID")
    private Long id;
    @Column(name = "USER_NAME")
    private String username;
    @Column(name = "USER_PASSWORD")
    private String password;
    @Column(name = "USER_ROLE")
    private int userRole;

    public UserData() {}

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
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

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return id + " : " + username;
    }
}