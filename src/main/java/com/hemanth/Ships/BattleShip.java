package com.hemanth.Ships;

public class BattleShip extends Ship {
    public static final Integer len=4;
    public static final String name="BattleShip";
    public static final Long id=1l;
    public BattleShip( Integer headRow, Integer headColumn, Boolean ishorizontal) {
        super(len, headRow, headColumn, ishorizontal,id,name);
    }
}
