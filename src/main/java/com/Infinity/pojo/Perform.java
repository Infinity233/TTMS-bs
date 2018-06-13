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
     * 票价
     */
    private Float price;    // 票价

    /**
     * 已售张数
     */
    private Integer sold;   // 已售张数

    /**
     * 开始时间
     */
    private Date startTime; // 开始时间

    /**
     * 结束时间
     */
    private Date endTime;   // 结束时间
    private Film film = new Film();
    private Studio studio = new Studio();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFilmId() {
        return film.getId();
    }

    public void setFilmId(Integer filmId) {
        film.setId(filmId);
    }

    public Integer getStudioId() {
        return studio.getId();
    }

    public void setStudioId(Integer studioId) {
        studio.setId(studioId);
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
                ", price=" + price +
                ", sold=" + sold +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", film=" + film +
                ", studio=" + studio +
                '}';
    }
}