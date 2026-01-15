package dev.marekvoe.defendtheorb.game;

import com.hypixel.hytale.math.vector.Vector3i;

public class EnemySpawner {

    private boolean active;
    private Vector3i position;


    public EnemySpawner(boolean active, Vector3i position) {
        this.active = active;
        this.position = position;
    }


    // TODO: Add arguments on what enemy to spawn, and how many enemies to spawn
    public void spawnEnemy() {

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Vector3i getPosition() {
        return position;
    }
}
