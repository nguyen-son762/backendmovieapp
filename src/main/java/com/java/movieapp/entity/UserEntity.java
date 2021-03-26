package com.java.movieapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String username;
    private String email;
    private String password;
    private Date createAt;
    private Date updateAt;
    public UserEntity() {
    }

    public UserEntity(String username, String email, String password, Date createAt, Date updateAt) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user",referencedColumnName = "user_id")
//    List<CommentEntity> comments=new ArrayList<>();

    public int getUserId() {
        return userId;
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

//    public List<CommentEntity> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<CommentEntity> comments) {
//        this.comments = comments;
//    }
}
