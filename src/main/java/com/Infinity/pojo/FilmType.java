package com.Infinity.pojo;

public class FilmType {
    private Integer id;

    private String typename;

    public FilmType() {
    }

    public FilmType(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "FilmType{" +
                "id=" + id +
                ", typename='" + typename + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }
}