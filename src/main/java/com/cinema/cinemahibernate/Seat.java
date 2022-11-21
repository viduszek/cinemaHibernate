package com.cinema.cinemahibernate;

import jakarta.persistence.*;

@Entity
public class Seat {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "row")
    private Integer row;
    @Basic
    @Column(name = "column")
    private Integer column;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Seat seat = (Seat) o;

        if (id != seat.id) return false;
        if (row != null ? !row.equals(seat.row) : seat.row != null) return false;
        if (column != null ? !column.equals(seat.column) : seat.column != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        result = 31 * result + (column != null ? column.hashCode() : 0);
        return result;
    }
}
