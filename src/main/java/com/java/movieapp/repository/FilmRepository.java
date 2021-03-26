package com.java.movieapp.repository;

import com.java.movieapp.entity.FilmEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<FilmEntity, Integer> {
    @Query("SELECT m FROM FilmEntity m WHERE m.category LIKE %?1% ")
    public  List<FilmEntity> getFilmByCategory(String key);
    @Query("SELECT m FROM FilmEntity m WHERE m.filmName LIKE %?1% ")
    public List<FilmEntity> searchFilm(String key);
}
