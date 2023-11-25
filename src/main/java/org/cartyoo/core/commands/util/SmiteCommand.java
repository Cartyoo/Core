package org.cartyoo.core.commands.util;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.cartyoo.core.Core;


public class SmiteCommand extends BaseCommand {

    @CommandAlias("smite|shock")
    @CommandPermission("core.command.smite")
    @Syntax("[player]")
    @CommandCompletion("@players")

    public static void onCommand(Player player, @Optional Player target) {
        if (target == null){
            Location location = player.getTargetBlock(null, 100).getLocation();
            location.getWorld().strikeLightning(location);
            player.sendMessage(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.smite").replaceAll("%target%", target.getName()));
        } else {
            target.getWorld().strikeLightning(target.getLocation());
            player.sendMessage(Core.getPrefix() + Core.getInstance().getConfig().getString("messages.smite-other").replaceAll("%target%", target.getName()));
        }
    }
}
