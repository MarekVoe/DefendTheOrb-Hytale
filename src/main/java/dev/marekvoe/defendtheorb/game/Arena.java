package dev.marekvoe.defendtheorb.game;

import com.hypixel.hytale.math.vector.Vector3i;
import com.hypixel.hytale.server.core.universe.Universe;

import java.util.ArrayList;

public class Arena {

    private ArrayList<EnemySpawner> enemySpawners;
    private Vector3i playerSpawner;
    private int minX, minY, minZ, maxX, maxY, maxZ;
    private Vector3i orbLocation;
    private Vector3i lobbyLocation;

    public Arena(ArrayList<EnemySpawner> enemySpawners, Vector3i playerSpawner, int minX, int minY, int minZ, int maxX, int maxY, int maxZ,  Vector3i orbLocation,  Vector3i lobbyLocation) {
        this.enemySpawners = enemySpawners;
        this.playerSpawner = playerSpawner;
        this.minX = minX;
        this.minY = minY;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxY = maxY;
        this.maxZ = maxZ;
        this.orbLocation = orbLocation;
        this.lobbyLocation = lobbyLocation;
    }

    public ArrayList getEnemySpawners() {
        return this.enemySpawners;
    }

    public Vector3i getPlayerSpawner() {
        return this.playerSpawner;
    }
}
