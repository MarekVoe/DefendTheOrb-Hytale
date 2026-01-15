package dev.marekvoe.defendtheorb.game;

import com.hypixel.hytale.server.core.universe.Universe;

public class GameManager {

    private GameState gameState;
    private Arena arena;

    // TODO: Implement arena loading from config files
    public GameManager() {

    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        switch(this.gameState) {
            case LOBBY:

            break;

            case PREP:
                // TODO: Broadcast that game has started
                // TODO: Start prep timer - when finished advance to IN_GAME status
            break;

            case IN_GAME:
            // TODO: Start enemy spawning, phases etc.
            // TODO: Main game loop, keep on playing until orb is destroyed
            break;


            case END:
            // TODO: Reset arena, broadcast winner etc.
            break;
        }
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Arena getActiveArena() {
        return this.arena;
    }
}
