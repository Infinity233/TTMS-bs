package com.Infinity.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * t_perform
 * @author 
 */
public class Perform implements Serializable {
    private Integer id;

    /**
     * 电影id
     */
    private Integer filmId;

    /**
     * 演出厅id
     */
    private Integer studioId;

    /**
     * 票价
     */
    private Float price;

    /**
     * 已售张数
     */
    private Integer sold;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

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

    public Integer getStudioId() {
        return studioId;
    }

    public void setStudioId(Integer studioId) {
        this.studioId = studioId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Perform{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", studioId=" + studioId +
                ", price=" + price +
                ", sold=" + sold +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}