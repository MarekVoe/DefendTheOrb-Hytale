package dev.marekvoe.defendtheorb.commands;

import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.command.system.CommandContext;
import com.hypixel.hytale.server.core.command.system.basecommands.AbstractTargetPlayerCommand;
import com.hypixel.hytale.server.core.command.system.basecommands.CommandBase;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.World;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.awt.*;

public class DefendTheOrbCommand extends AbstractTargetPlayerCommand {

    public DefendTheOrbCommand(@Nonnull String name, @Nonnull String description) {
        super(name, description);
    }

    @Override
    protected void execute(@Nonnull CommandContext commandContext, @Nullable Ref<EntityStore> ref,
                           @Nonnull Ref<EntityStore> ref1, @Nonnull PlayerRef playerRef,
                           @Nonnull World world, @Nonnull Store<EntityStore> store) {
        if (!commandContext.isPlayer()) {
            commandContext.sender().sendMessage(Message.raw("Only players can use this command !").color(Color.RED));
        }
        
    }
}
