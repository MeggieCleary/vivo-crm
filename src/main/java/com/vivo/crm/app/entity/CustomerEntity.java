package com.vivo.crm.app.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

    @Column(nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(length = 50)
    private String email;

    @Column(length = 100)
    private String encryptedPassword;

    @Column(nullable = false, unique = true)
    private String userId;

    public CustomerEntity(String lastName, String firstName, String email, String encryptedPassword, String userId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.userId = userId;
    }

    public CustomerEntity () {}

    @Id
    @GeneratedValue
    private Long id;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
