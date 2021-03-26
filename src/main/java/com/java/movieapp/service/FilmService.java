package com.java.movieapp.service;

import com.java.movieapp.entity.FilmEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Stream;

public interface FilmService {
    FilmEntity saveFilm(FilmEntity film);
    List<FilmEntity> getAllFilms();
    FilmEntity getFilmById(int id);
    List<FilmEntity> searchFilmByName(String name);
    List<FilmEntity> getFilmByCategory(String category);
    Page<FilmEntity> findPagination(int pageNo, int pageSize);
}
