package dev.marekvoe.defendtheorb;

import com.hypixel.hytale.server.core.event.events.player.AddPlayerToWorldEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.plugin.JavaPlugin;
import com.hypixel.hytale.server.core.plugin.JavaPluginInit;
import dev.marekvoe.defendtheorb.game.GameManager;
import dev.marekvoe.defendtheorb.game.GameState;
import dev.marekvoe.defendtheorb.listeners.PlayerListener;

import javax.annotation.Nonnull;

public class DefendTheOrb extends JavaPlugin {

    public static final String prefix = "[DefendTheOrb]";
    private GameManager gameManager;

    public DefendTheOrb(@Nonnull JavaPluginInit init) {
        super(init);
    }

    private void registerCommands() {

    }

    private void registerListeners() {
        PlayerListener playerListener = new PlayerListener(this);

        getEventRegistry().registerGlobal(PlayerReadyEvent.class, playerListener::onReadyPlayer);
        getEventRegistry().registerGlobal(PlayerDisconnectEvent.class, playerListener::onPlayerDisconnect);
        getEventRegistry().registerGlobal(AddPlayerToWorldEvent.class, playerListener::handleAddPlayerToWorld);
    }

    private void registerManagers() {
        this.gameManager = new GameManager();
    }

    @Override
    protected void setup() {
        super.setup();
        this.registerManagers();
        this.registerCommands();
        this.registerListeners();
        gameManager.setGameState(GameState.LOBBY);
    }

    public GameManager getGameManager() {
        return this.gameManager;
    }
}
