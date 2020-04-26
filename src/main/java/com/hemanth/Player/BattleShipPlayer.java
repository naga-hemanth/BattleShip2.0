package com.hemanth.Player;

import java.security.PublicKey;
import java.util.HashMap;

public class BattleShipPlayer extends BoardGamePlayer {

    private Integer aliveShips = 5;

    public BattleShipPlayer(String name, Integer age, Long id, HashMap<String, String> metaData) {
        super(name, age, id, metaData);
    }

    public void aliveShipsDecrementer() {
        System.out.println("Decrementing " + this.getName() + " Ship as it was sunk");
        decreaseAliveShip();
    }
    public void decreaseAliveShip(){
        this.aliveShips--;
    }
    public Integer getAliveShips() {
        return aliveShips;
    }
}
