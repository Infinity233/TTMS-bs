package com.Infinity.pojo;

import java.io.Serializable;

/**
 * t_ticket
 * @author 
 */
public class Ticket implements Serializable {
    private Integer id;

    /**
     * 演出计划id
     */
    private Integer performId;

    /**
     * 座位行号
     */
    private Integer row;

    /**
     * 座位列号
     */
    private Integer col;

    /**
     * 座位状态
     */
    private Integer seatTypeId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerformId() {
        return performId;
    }

    public void setPerformId(Integer performId) {
        this.performId = performId;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public void setCol(Integer col) {
        this.col = col;
    }

    public Integer getSeatTypeId() {
        return seatTypeId;
    }

    public void setSeatTypeId(Integer seatTypeId) {
        this.seatTypeId = seatTypeId;
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
        Ticket other = (Ticket) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPerformId() == null ? other.getPerformId() == null : this.getPerformId().equals(other.getPerformId()))
            && (this.getRow() == null ? other.getRow() == null : this.getRow().equals(other.getRow()))
            && (this.getCol() == null ? other.getCol() == null : this.getCol().equals(other.getCol()))
            && (this.getSeatTypeId() == null ? other.getSeatTypeId() == null : this.getSeatTypeId().equals(other.getSeatTypeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPerformId() == null) ? 0 : getPerformId().hashCode());
        result = prime * result + ((getRow() == null) ? 0 : getRow().hashCode());
        result = prime * result + ((getCol() == null) ? 0 : getCol().hashCode());
        result = prime * result + ((getSeatTypeId() == null) ? 0 : getSeatTypeId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", performId=" + performId +
                ", row=" + row +
                ", col=" + col +
                ", seatTypeId=" + seatTypeId +
                '}';
    }
}