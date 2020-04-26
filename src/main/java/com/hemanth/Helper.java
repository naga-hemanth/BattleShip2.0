package com.hemanth;

public class Helper {
    private Integer headRow;
    private Integer headColumn;
    private Boolean isHorizontal;

    public Helper(Integer headRow, Integer headColumn, Boolean isHorizontal) {
        this.headRow = headRow;
        this.headColumn = headColumn;
        this.isHorizontal = isHorizontal;
    }

    public Integer getHeadRow() {
        return headRow;
    }

    public void setHeadRow(Integer headRow) {
        this.headRow = headRow;
    }

    public Integer getHeadColumn() {
        return headColumn;
    }

    public void setHeadColumn(Integer headColumn) {
        this.headColumn = headColumn;
    }

    public Boolean getHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(Boolean horizontal) {
        isHorizontal = horizontal;
    }
}
