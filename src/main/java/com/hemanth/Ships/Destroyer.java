package com.hemanth.Ships;

public class Destroyer extends Ship {
    public static final Integer len=2;
    public static final String name="Destroyer";
    public static final Long id=4l;
    public Destroyer(Integer headRow, Integer headColumn, Boolean ishorizontal) {
        super(len, headRow, headColumn, ishorizontal,id,name);
    }
}
