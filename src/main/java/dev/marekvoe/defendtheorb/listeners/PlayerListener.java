package dev.marekvoe.defendtheorb.listeners;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.math.vector.Transform;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.event.events.player.AddPlayerToWorldEvent;
import com.hypixel.hytale.server.core.event.events.player.DrainPlayerFromWorldEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerDisconnectEvent;
import com.hypixel.hytale.server.core.event.events.player.PlayerReadyEvent;
import com.hypixel.hytale.server.core.modules.accesscontrol.ban.Ban;
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
        Ref<EntityStore> playerRef = player.getReference();

        if (!plugin.getGameManager().getGameState().canJoin()) {
            // TODO: Kick palyer when game has already started
            return;
        }
        for (PlayerRef players : universe.getPlayers()) {
            players.sendMessage(Message.raw(player.getDisplayName() + " has joined the game!").color(Color.GREEN));
        }

        // TODO: Load world from config file not the world that player currently is in
        // Note: maybe transfer all the teleport logic to Util.java class or make PlayerManager.java class and do all the player stuff there
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
