package com.agenda.agenda.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;


@Document(collection = "account")
public class Account {

    @Id
    private String id;
    private String nickname;
    private String password;
    private String email;
    private boolean activated;
    private Instant creationdate;

    public Account(String id, String nickname, String password, String email, boolean activated, Instant creationdate) {
        this.id = id;
        this.nickname = nickname;
        this.password = password;
        this.email = email;
        this.activated = false;
    }

    public Account() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Instant getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Instant creationdate) {
        this.creationdate = creationdate;
    }
}
