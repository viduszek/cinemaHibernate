package com.cinema.cinemahibernate;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Screening {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "movie_id")
    private Integer movieId;
    @Basic
    @Column(name = "date_time")
    private Timestamp dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Screening screening = (Screening) o;

        if (id != screening.id) return false;
        if (movieId != null ? !movieId.equals(screening.movieId) : screening.movieId != null) return false;
        if (dateTime != null ? !dateTime.equals(screening.dateTime) : screening.dateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (dateTime != null ? dateTime.hashCode() : 0);
        return result;
    }
}
