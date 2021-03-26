package com.java.movieapp.entity;

import java.util.Date;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private Date createAt;
    private Date updateAt;

    public RegisterRequest(String username, String email, String password, Date createAt, Date updateAt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
