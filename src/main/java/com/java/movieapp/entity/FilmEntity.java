package com.java.movieapp.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="film")
public class FilmEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    private int filmId;
    private String filmName;
    @Column(name = "source_url")
    private String soureUrl;
    @Column(name = "trailer_url")
    private String trailerUrl;
    private String image;
    private String yearRelease;
    private String filmType;
    private String category;
    private String national;
    private String actors;
    private String contentFilm;
    private float star;
    private int numberReviews;

    public FilmEntity() {
    }

    public FilmEntity(String filmName, String soureURL, String trailerURL, String image, String yearRelease, String filmType, String category, String national, String actors, String contentFilm, float star, int numberReviews) {
        this.filmName = filmName;
        this.soureUrl = soureURL;
        this.trailerUrl = trailerURL;
        this.image = image;
        this.yearRelease = yearRelease;
        this.filmType = filmType;
        this.category = category;
        this.national = national;
        this.actors = actors;
        this.contentFilm = contentFilm;
        this.star = star;
        this.numberReviews = numberReviews;
    }
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "fk_film",referencedColumnName = "film_id")
//    List<CommentEntity> comments=new ArrayList<>();

    public int getId() {
        return filmId;
    }


    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getSoureURL() {
        return soureUrl;
    }

    public void setSoureURL(String soureURL) {
        this.soureUrl = soureURL;
    }

    public String getTrailerURL() {
        return trailerUrl;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerUrl = trailerURL;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getYearRelease() {
        return yearRelease;
    }

    public void setYearRelease(String yearRelease) {
        this.yearRelease = yearRelease;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getContentFilm() {
        return contentFilm;
    }

    public void setContentFilm(String contentFilm) {
        this.contentFilm = contentFilm;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public int getNumberReviews() {
        return numberReviews;
    }

    public void setNumberReviews(int numberReviews) {
        this.numberReviews = numberReviews;
    }

//    public List<CommentEntity> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<CommentEntity> comments) {
//        this.comments = comments;
//    }
}
