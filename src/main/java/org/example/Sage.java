package org.example;

public class Sage {

    private String name;
    private int health;

    public Sage(String name) {
        this.name = name;
        this.health = 5;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
