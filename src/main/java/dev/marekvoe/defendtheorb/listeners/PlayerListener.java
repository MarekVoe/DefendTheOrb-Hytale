package dev.marekvoe.defendtheorb.listeners;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.AddPlayerToWorldEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import dev.marekvoe.defendtheorb.DefendTheOrb;

import java.awt.*;

public class PlayerListener {

    private DefendTheOrb plugin;

    public PlayerListener(final DefendTheOrb plugin) {
        this.plugin = plugin;
    }

    public void onReadyPlayer(PlayerReadyEvent event) {
        Player player = event.getPlayer();
        Universe universe = Universe.get();

        if (!plugin.getGameManager().getGameState().canJoin()) {
            // Kick player if the game state does not allow joining
            return;
        }
        for (PlayerRef players : universe.getPlayers()) {
            players.sendMessage(Message.raw(player.getDisplayName() + " has joined the game!").color(Color.GREEN));
        }
    }

    public void handleAddPlayerToWorld(AddPlayerToWorldEvent event) {
        event.setBroadcastJoinMessage(false);
    }

    public void onPlayerDisconnect(PlayerDisconnectEvent event) {
        PlayerRef player = event.getPlayerRef();
        Universe universe = Universe.get();
        for (PlayerRef players : universe.getPlayers()) {
            players.sendMessage(Message.raw(player.getUsername() + " has left the game!").color(Color.RED));
        }
    }
}
