package dev.marekvoe.defendtheorb.game;

public class GameManager {

    private GameState gameState;

    public GameManager() {

    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        switch(this.gameState) {
            case LOBBY:

            break;

            case PREP:

            break;


            case IN_GAME:

            break;


            case END:

            break;
        }
    }


    public GameState getGameState() {
        return this.gameState;
    }
}
