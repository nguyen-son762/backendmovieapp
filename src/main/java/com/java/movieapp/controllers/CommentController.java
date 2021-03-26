package com.java.movieapp.controllers;

import com.java.movieapp.entity.CommentEntity;
import com.java.movieapp.entity.FilmEntity;
import com.java.movieapp.entity.UserEntity;
import com.java.movieapp.service.CommentService;
import com.java.movieapp.service.FilmService;
import com.java.movieapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private UserService userService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private CommentService commentService;
    @CrossOrigin
    @GetMapping("/comment/{id}")
    public ResponseEntity<Object> getCmt(@PathVariable String id){
        HashMap map=new HashMap();
        List<CommentEntity> commentEntityList= commentService.getComments().stream().filter(e->e.getFilmEntity().getId()==Integer.parseInt(id)).collect(Collectors.toList());
        map.put("comment",commentEntityList);
        return new ResponseEntity(map, HttpStatus.OK);
    }
    @PostMapping("/comments/{filmid}/{id}/add")
    public CommentEntity addComment(@PathVariable String id, @PathVariable String filmid, @RequestBody CommentEntity commentEntity){
        UserEntity user=userService.findUserById(Integer.parseInt(id));
        FilmEntity filmEntity=filmService.getFilmById(Integer.parseInt(filmid));
        commentEntity.setUserEntity(user);
        commentEntity.setFilmEntity(filmEntity);
        java.util.Date date=new java.util.Date();
        commentEntity.setCreateAt(date);
        commentEntity.setUpdateAt(date);
        commentService.saveCmt(commentEntity);
        return commentEntity;
    }
    @DeleteMapping("/comments/delete/{id}")
    public ResponseEntity<Object> deleteComment(@PathVariable String id){
        Optional<CommentEntity> id1=commentService.getCmtById(Integer.valueOf(id));
        if(id1.isPresent()){
            commentService.deleteCmt(Integer.parseInt(id));
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

}
