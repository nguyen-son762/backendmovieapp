package com.java.movieapp.service;

import com.java.movieapp.entity.FilmEntity;
import com.java.movieapp.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.domain.Pageable;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;
    @Override
    public FilmEntity saveFilm(FilmEntity film) {
        return filmRepository.save(film);
    }

    @Override
    public List<FilmEntity> getAllFilms() {

        return filmRepository.findAll();
    }

    @Override
    public FilmEntity getFilmById(int id) {
        Optional<FilmEntity> optional =filmRepository.findById(id);

        FilmEntity filmEntity = null;
        if (optional.isPresent()) {
            filmEntity = optional.get();
        } else {
            throw new RuntimeException(" Film not found for id :: " + id);
        }
        return filmEntity;
    }


    @Override
    public List<FilmEntity> searchFilmByName(String name) {
        return filmRepository.searchFilm(name);
    }

    @Override
    public List<FilmEntity> getFilmByCategory(String category) {
        return filmRepository.getFilmByCategory(category);
    }

    @Override
    public Page<FilmEntity> findPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return filmRepository.findAll(pageable);
    }

}
