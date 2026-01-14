package dev.marekvoe.defendtheorb.game;

public enum GameState {
    LOBBY(true),
    PREP(false),
    IN_GAME(false),
    END(true);

    private final boolean canJoin;

    GameState(boolean canJoin) {
        this.canJoin = canJoin;
    }

    public boolean canJoin() {
        return canJoin;
    }
}