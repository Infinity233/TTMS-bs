package com.Infinity.pojo;

public class Seat {

    private Integer seatId;
    private int row;
    private int col;
    private SeatType seatType;

    private Studio studio;

    public Seat() {
    }

    public Seat(int row, int col, SeatType seatType, Studio studio) {
        this.row = row;
        this.col = col;
        this.seatType = seatType;
        this.studio = studio;
    }

    public int getStudioId() {
        return studio.getId();
    }

    public void setStudioId(Integer id) {
        studio.setId(id);
    }

    public int getSeatTypeId() {
        return seatType.getId();
    }

    public void setId(Integer id) {
        seatType.setId(id);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", row=" + row +
                ", col=" + col +
                ", seatType=" + seatType +
                ", studio=" + studio +
                '}';
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }
}