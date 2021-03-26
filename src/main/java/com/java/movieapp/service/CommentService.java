package com.java.movieapp.service;

import com.java.movieapp.entity.CommentEntity;

import java.util.List;
import java.util.Optional;

public interface CommentService {
    CommentEntity saveCmt(CommentEntity commentEntity);
    void deleteCmt(Integer id);
    List<CommentEntity> getComments();
    Optional<CommentEntity> getCmtById(int id);
}
