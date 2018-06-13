package com.Infinity.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * t_film
 * @author 
 */
public class Film implements Serializable {
    private Integer id;

    /**
     * 电影名称
     */
    private String name;

    /**
     * 封面图片
     */
    private String cover;

    /**
     * 电影时长
     */
    private Integer duration;

    /**
     * 票房
     */
    private Integer box = 0;

    /**
     * 豆瓣得分
     */
    private Double score;

    /**
     * 是否热门
     */
    private Integer isHot = 0;

    /**
     * 点击次数
     */
    private Integer clickHit;

    private Date publishDate;

    /**
     * 描述
     */
    private String resume;

    private Employee director;              // 导演
    private List<FilmType> filmTypes;       // 电影类型
    private List<Employee> employees;       // 演员

    private static final long serialVersionUID = 1L;

    public Integer getEmployeeId() {
        return director.getId();
    }

    public void setEmployeeId(Integer id) {
        director.setId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getIsHot() {
        return isHot;
    }

    public void setIsHot(Integer isHot) {
        this.isHot = isHot;
    }

    public Integer getClickHit() {
        return clickHit;
    }

    public void setClickHit(Integer clickHit) {
        this.clickHit = clickHit;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }


    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) {
        this.director = director;
    }

    public List<FilmType> getFilmTypes() {
        return filmTypes;
    }

    public void setFilmTypes(List<FilmType> filmTypes) {
        this.filmTypes = filmTypes;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cover='" + cover + '\'' +
                ", duration=" + duration +
                ", box=" + box +
                ", score=" + score +
                ", isHot=" + isHot +
                ", clickHit=" + clickHit +
                ", publishDate=" + publishDate +
                ", resume='" + resume + '\'' +
                ", director=" + director +
                ", filmTypes=" + filmTypes +
                ", employees=" + employees +
                '}';
    }
}