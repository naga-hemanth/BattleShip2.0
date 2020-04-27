package com.hemanth.Ships;

public class Submarine extends Ship {
    public static final Integer len=3;
    public static final String name="Submarine";
    public static final Long id=5l;
    public Submarine(Integer headRow, Integer headColumn, Boolean ishorizontal) {
        super(len, headRow, headColumn, ishorizontal,id,name);
    }
}
