package com.hemanth.Ships;

public class Cruiser extends Ship{
    public static final Integer len=3;
    public static final String name="Cruiser";
    public static final Long id=3l;
    public Cruiser(Integer headRow, Integer headColumn, Boolean ishorizontal) {
        super(len, headRow, headColumn, ishorizontal,id,name);
    }
}
