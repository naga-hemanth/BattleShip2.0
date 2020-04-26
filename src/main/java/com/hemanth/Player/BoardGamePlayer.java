package com.hemanth.Player;

import java.util.HashMap;

public abstract class BoardGamePlayer extends Player {
    public BoardGamePlayer(String name, Integer age, Long id, HashMap<String, String> metaData) {
        super(name, age, id, metaData);
    }
}
