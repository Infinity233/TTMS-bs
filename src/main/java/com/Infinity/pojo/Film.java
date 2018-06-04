package com.Infinity.pojo;

import java.io.Serializable;
import java.util.Date;

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
    private Integer box;

    /**
     * 豆瓣得分
     */
    private Double score;

    /**
     * 是否热门
     */
    private Integer isHot;

    /**
     * 点击次数
     */
    private Integer clickHit;

    private Integer employeeId;

    private Date publishDate;

    /**
     * 描述
     */
    private String resume;

    private static final long serialVersionUID = 1L;

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

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", cover=").append(cover);
        sb.append(", duration=").append(duration);
        sb.append(", box=").append(box);
        sb.append(", score=").append(score);
        sb.append(", isHot=").append(isHot);
        sb.append(", clickHit=").append(clickHit);
        sb.append(", employeeId=").append(employeeId);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", resume=").append(resume);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}