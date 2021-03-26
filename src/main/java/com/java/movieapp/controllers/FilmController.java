package com.java.movieapp.controllers;

import com.java.movieapp.entity.FilmEntity;
import com.java.movieapp.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class FilmController {
    private static final int pageSize = 15;
    @Autowired
    FilmService filmService;
    @GetMapping("/getfilms")
    public ResponseEntity<Object> getFilms(){
        HashMap map=new HashMap();
        map.put("odd",filmService.getFilmByCategory("Phim le").stream().limit(10));
        map.put("cinema",filmService.getFilmByCategory("Phim chieu rap").stream().limit(10));
        map.put("action",filmService.getFilmByCategory("Phim hanh ").stream().limit(10));
        map.put("cartoon",filmService.getFilmByCategory("Phim hoat hinh").stream().limit(10));
        return new ResponseEntity(map, HttpStatus.OK);
    }
    @GetMapping("/film")
    public List<FilmEntity> get(){
         return filmService.getAllFilms();
    }
    @GetMapping("/film/{id}")
    public FilmEntity getFilmById(@PathVariable int id){
        return filmService.getFilmById(id);
    }
    @GetMapping("/film/search")
    public List<FilmEntity> searchByName(@RequestParam String query){
        return filmService.searchFilmByName(query);
    }
    @GetMapping("/film/phim-le")
    public Map<String,Object> findPaginated(@RequestParam int page) {
        Page<FilmEntity> pageX = filmService.findPagination(page, pageSize);
        HashMap<String,Object> res=new HashMap<>();
        res.put("items",pageX.getContent());
        res.put("total",pageX.getTotalPages());
        res.put("totalItems", pageX.getTotalElements());
        return res;
    }
    @GetMapping("/film/phim-hai-huoc")
    public Map<String,Object> findPaginatedComedy(@RequestParam int page) {
        List<FilmEntity> filmEntityList=filmService.getFilmByCategory("Phim hai huoc");
        HashMap<String,Object> res=new HashMap<>();
        res.put("items",filmEntityList);
        return res;
    }
    @GetMapping("/film/phim-hoat-hinh")
    public Map<String,Object> findPaginatedFilmCartoon(@RequestParam int page) {
        List<FilmEntity> filmEntityList=filmService.getFilmByCategory("Phim hoat hinh");
        HashMap<String,Object> res=new HashMap<>();
        res.put("items",filmEntityList);
        return res;
    }
    @GetMapping("/film/phim-hanh-dong")
    public Map<String,Object> findPaginatedFilmAction(@RequestParam int page) {
        List<FilmEntity> filmEntityList=filmService.getFilmByCategory("Phim hanh");
        HashMap<String,Object> res=new HashMap<>();
        res.put("items",filmEntityList);
        return res;
    }
}
