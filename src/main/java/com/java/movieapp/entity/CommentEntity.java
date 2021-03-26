package com.java.movieapp.entity;

import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private int commentId;
    private String content;
    private Date createAt;
    private Date updateAt;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "film_id", referencedColumnName = "film_id")
    private FilmEntity filmEntity;
    public CommentEntity() {
    }

    public CommentEntity(String content, Date createAt, Date updateAt) {
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
//    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_user", referencedColumnName = "user_id")
//    private UserEntity userEntity;

    public int getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

//    public String getUserId() {
//        return userId;
//    }
//
//    public void setUserId(String userId) {
//        this.userId = userId;
//    }


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

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public FilmEntity getFilmEntity() {
        return filmEntity;
    }

    public void setFilmEntity(FilmEntity filmEntity) {
        this.filmEntity = filmEntity;
    }
}
