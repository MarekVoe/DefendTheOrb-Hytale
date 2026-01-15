package dev.marekvoe.defendtheorb.listeners;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.component.system.RefSystem;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.Entity;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.AddPlayerToWorldEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.modules.entity.teleport.Teleport;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.Universe;
import com.hypixel.hytale.server.core.universe.world.World;
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
            // TODO: Kick player if the game state does not allow joining
            return;
        }
        for (PlayerRef players : universe.getPlayers()) {
            players.sendMessage(Message.raw(player.getDisplayName() + " has joined the game!").color(Color.GREEN));
        }

        // TODO: Load world from config file not the world that player currently is in
        World world = player.getWorld();
        if (world == null) return;
        world.execute(() -> {
           if (player.getReference() == null) return;
            Store<EntityStore> store = player.getReference().getStore();
            Teleport teleport = new Teleport(new Transform(plugin.getGameManager().getActiveArena().getPlayerSpawner().x,
                    plugin.getGameManager().getActiveArena().getPlayerSpawner().y,
                    plugin.getGameManager().getActiveArena().getPlayerSpawner().z));
            store.addComponent(player.getReference(), Teleport.getComponentType(), teleport);
        });
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
