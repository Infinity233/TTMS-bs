package com.Infinity.pojo;

import java.io.Serializable;

/**
 * t_film_filmtype
 * @author 
 */
public class FilmFilmtype implements Serializable {
    private Integer id;

    private Integer filmId;

    private Integer filmTypeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getFilmTypeId() {
        return filmTypeId;
    }

    public void setFilmTypeId(Integer filmTypeId) {
        this.filmTypeId = filmTypeId;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        FilmFilmtype other = (FilmFilmtype) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFilmId() == null ? other.getFilmId() == null : this.getFilmId().equals(other.getFilmId()))
            && (this.getFilmTypeId() == null ? other.getFilmTypeId() == null : this.getFilmTypeId().equals(other.getFilmTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFilmId() == null) ? 0 : getFilmId().hashCode());
        result = prime * result + ((getFilmTypeId() == null) ? 0 : getFilmTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", filmId=").append(filmId);
        sb.append(", filmTypeId=").append(filmTypeId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}