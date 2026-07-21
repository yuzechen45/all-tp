package com.alltp.mod;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.CommandNode;
import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.lang.reflect.Field;
import java.util.function.Predicate;

public class TPEventHandler {

    @SubscribeEvent
    public void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSource> dispatcher = event.getDispatcher();
        CommandNode<CommandSource> root = dispatcher.getRoot();

        patchCommand(root, "tp");
        patchCommand(root, "teleport");
    }

    private void patchCommand(CommandNode<CommandSource> root, String name) {
        CommandNode<CommandSource> node = root.getChild(name);
        if (node != null) {
            try {
                Field field = CommandNode.class.getDeclaredField("requirement");
                field.setAccessible(true);
                field.set(node, (Predicate<CommandSource>) source -> true);
            } catch (Exception ignored) {
            }
        }
    }
}
