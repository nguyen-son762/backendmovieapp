package com.java.movieapp.service;

import com.java.movieapp.entity.CommentEntity;
import com.java.movieapp.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl  implements CommentService  {
    @Autowired
    private CommentRepository commentRepository;
    @Override
    public CommentEntity saveCmt(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }

    @Override
    public void deleteCmt(Integer id) {
        Optional<CommentEntity> optional =commentRepository.findById(id);
        if (optional.isPresent()) {
            this.commentRepository.deleteById(id);
        } else {
            throw new RuntimeException(" Comment not found for id :: " + id);
        }
    }

    @Override
    public List<CommentEntity> getComments() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<CommentEntity> getCmtById(int id) {
        return commentRepository.findById(id);
    }

}
