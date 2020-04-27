package com.hemanth.Ships;

public abstract class Ship {
    private Long uniqueId;
    private String name;
    private Integer length;
    private Integer headRow;
    private Integer headColumn;
    private Boolean ishorizontal;
    private Integer hits = 0;
    private Boolean isSunk = false;

    public Ship(Integer length, Integer headRow, Integer headColumn, Boolean ishorizontal, Long uniqueId,String name1) {
        this.length = length;
        this.headRow = headRow;
        this.headColumn = headColumn;
        this.ishorizontal = ishorizontal;
        this.uniqueId = uniqueId;
        this.name=name1;
    }

    public String getName() {
        return name;
    }

    public Long getUniqueId() {
        return uniqueId;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getHeadRow() {
        return headRow;
    }

    public Integer getHeadColumn() {
        return headColumn;
    }

    public Boolean getIshorizontal() {
        return ishorizontal;
    }

    public void hitOnShip(){
        this.hits++;
        if (this.hits==this.length){
            this.isSunk=true;
        }
    }

    public Integer getHits() {
        return hits;
    }

    public Boolean getSunk() {
        return isSunk;
    }
}
