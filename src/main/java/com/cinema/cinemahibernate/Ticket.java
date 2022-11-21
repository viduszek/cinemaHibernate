package com.cinema.cinemahibernate;

import jakarta.persistence.*;

@Entity
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "client_id")
    private Integer clientId;
    @Basic
    @Column(name = "movie_id")
    private Integer movieId;
    @Basic
    @Column(name = "seat_id")
    private Integer seatId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (id != ticket.id) return false;
        if (clientId != null ? !clientId.equals(ticket.clientId) : ticket.clientId != null) return false;
        if (movieId != null ? !movieId.equals(ticket.movieId) : ticket.movieId != null) return false;
        if (seatId != null ? !seatId.equals(ticket.seatId) : ticket.seatId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (movieId != null ? movieId.hashCode() : 0);
        result = 31 * result + (seatId != null ? seatId.hashCode() : 0);
        return result;
    }
}
