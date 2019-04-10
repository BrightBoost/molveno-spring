package com.molveno.molveno.restaurant.chillFlix;

import javax.persistence.*;
import javax.validation.constraints.Max;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "movie")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Access(AccessType.PROPERTY)
    private long id;

    @Column(name = "title")
    private String title;
    @Column(name = "director")
    private String director;
    @Column(name = "releasedate")
    private String releaseDate;
    @Column(name = "url")
    private String url;
    @Column(name = "moviecategory")
    private String movieCategory;

@Column(name = "description" ,columnDefinition="LONGTEXT")
    private String description;
@Column(name="favoritestatus")
private boolean favoriteStatus;
@Column(name="Time")
private LocalDateTime time;
    @Column(name="counter")
    private int counter;

    @Column(name = "favoriteconuter")
    private  int favoriteCounter;

    public int getFavoriteCounter() {
        return favoriteCounter;
    }

    public void setFavoriteCounter(int favoriteCounter) {
        this.favoriteCounter = favoriteCounter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public boolean isFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(boolean favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(String movieCategory) {
        this.movieCategory = movieCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


}
