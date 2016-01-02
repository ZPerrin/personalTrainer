package com.pt.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  User Entity
 */
@Entity
@Table(name = "User")
public class User {

    @Id
    private Integer id;

    @Column(name = "FIRST_NAME")
    String firstName;

    @Column(name = "LAST_NAME")
    String lastName;

    @Column(name="DISPLAY_NAME")
    String displayName;

    @Column(name = "EMAIL", nullable = false)
    String email;

    @Column(name = "PASSWORD", nullable = false)
    String password;

    public User() {
    }

    public User(Integer id, String displayName, String email) {
        this.id = id;
        this.displayName = displayName;
        this.email = email;
    }

    public User(User user) {
        this.id = user.id;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.displayName = user.displayName;
        this.email = user.email;
        this.password = user.password;
    }

    public User(String email, Integer id, String firstName, String lastName, String displayName) {
        this.email = email;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
