package com.hemanth.Ships;

public class Carrier extends Ship {
    public static final Integer len=5;
    public static final String name="Carrier";
    public static final Long id=2l;
    public Carrier(Integer headRow, Integer headColumn, Boolean ishorizontal) {
        super(len, headRow, headColumn, ishorizontal,id,name);
    }
}
