package dev.marekvoe.defendtheorb.game;

public class Orb {

    private int health;
    private final int maxHealth;

    public Orb(int health, int maxHealth) {
        this.health = health;
        this.maxHealth = maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
