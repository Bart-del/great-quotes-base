package pl.bartdel.quotesbasespring.dao.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String password;
    @Transient
    private String matchingPassword;
    private UserRole userRole;
    public User() {
    }

    public User(String login, String password, String matchingPassword, UserRole userRole) {
        this.login = login;
        this.password = password;
        this.userRole = userRole;
        this.matchingPassword = matchingPassword;
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

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", matchingPassword='" + matchingPassword + '\'' +
                ", role='" + userRole + '\'' +
                '}';
    }
}
