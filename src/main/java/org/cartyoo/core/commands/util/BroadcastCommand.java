package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BroadcastCommand extends BaseCommand {
    @CommandAlias("broadcast|bc")
    @CommandPermission("core.command.broadcast")
    @Syntax("")
    public static void onCommand(Player player, String msg) {
        Bukkit.broadcastMessage(msg);
    }
}
