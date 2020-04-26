package com.hemanth.Player;

import java.util.HashMap;

public abstract class Player {
    private String name;
    private Integer age;
    private Long id;
    private HashMap<String, String> metaData;

    public Player(String name, Integer age, Long id, HashMap<String, String> metaData) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.metaData = metaData;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Long getId() {
        return id;
    }

    public HashMap<String, String> getMetaData() {
        return metaData;
    }
}
